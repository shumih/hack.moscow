const puppeteer = require('puppeteer');
const http = require('request-promise');

let _browser;
let pageMap = new Map();

async function getIds(length = 132893) {
  const toReturn = [];
  let page = await getHtmlPageOf(`https://declarator.org/person`);
  let olElement = await page.$('.persons_list > ol');
  let anchorElements = await olElement.$$('li > a');
  const recordsPerPage = anchorElements.length;

  await parseElements(anchorElements);

  const pages = await Promise.all(
    Array.from({ length: Math.ceil(recordsPerPage / length) }).map((_, i) =>
      getHtmlPageOf(`https://declarator.org/person?page=${i + 1}`)
    )
  );
  const olElements = await Promise.all(pages.map(page => page.$('.persons_list > ol')));
  const arraysOfLiElements = await Promise.all(olElements.map(olElement => olElement.$$('li > a')));

  for (let liElements of arraysOfLiElements) {
    console.log(Math.ceil(recordsPerPage / length));

    try {
      await parseElements(liElements);
    } catch (e) {
      console.log(e);
    }
  }

  return toReturn;

  async function parseElements(els) {
    for (let el of els) {
      const hrefProp = await el.getProperty('href');
      const idString = (await hrefProp.jsonValue()) || '';
      const id = parseInt(idString.replace(/\D/g, ''), 10);

      if (id) {
        const textContentProp = await el.getProperty('textContent');
        const name = await textContentProp.jsonValue();

        const [{ results: incomes }, { results: realstates }, { results: vehicles }] = await Promise.all([
          http.get(`https://declarator.org/api/get-year-income/${id}`).json(),
          http.get(`https://declarator.org/api/get-year-realestate/${id}`).json(),
          http.get(`https://declarator.org/api/get-year-vehicles-count/${id}`).json(),
        ]);

        console.count('get-year-income');
        toReturn.push({ id, name, incomes, realstates, vehicles });
      }
    }
  }
}

async function getAvatar(id) {
  const htmlPage = await getHtmlPageOf(`https://declarator.org/person/${id}`);

  if (!htmlPage) {
    return;
  }

  return getImage(htmlPage);
}

async function getHtmlPageOf(url) {
  const browser = _browser ? _browser : (_browser = await puppeteer.launch({ ignoreHTTPSErrors: true }));

  let page;
  if (pageMap.has(url)) {
    page = pageMap.get(url);
  } else {
    page = await browser.newPage();
    pageMap.set(url, page);
  }

  const response = await page.goto(url, { waitUntil: 'networkidle0' });

  const contentType = response.headers()['content-type'];

  if (!contentType || !contentType.includes('html')) {
    return null;
  }

  return page;
}

async function getImage(htmlPage) {
  const imageEl = await htmlPage.$('.photo img');
  const srcProperty = await imageEl.getProperty('src');
  const src = await srcProperty.jsonValue();
  const page = await htmlPage.goto(src);
  return page.buffer();
}

module.exports = { getAvatar, getIds };
