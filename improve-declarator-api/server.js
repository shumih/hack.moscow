const express = require('express');
const dotenv = require('dotenv');
const path = require('path');
const { parse } = require('url');
const { getAvatar, getIds: getPoliticians } = require('./scrap');

const app = express();

/**
 * Load environment variables from .env file to process.env
 */
dotenv.config({
  path: path.resolve(__dirname, '.env'),
});

/**
 * Express configuration
 */
app.set('port', process.env.PORT);

/**
 * Controllers
 */
app.get('/api/avatar/:id', async (request, response) => {
  const avatar = await getAvatar(request.params.id);

  response.write(avatar);
});

app.get('/api/politicians', async (request, response) => {
  const { query } = parse(request.url, true);

  const politicians = await getPoliticians(parseInt(query.limit, 10));

  response.write(JSON.stringify({ data: politicians }, ' ', 2));
});

/**
 * Start express server
 */
app.listen(app.get('port'), () => {
  console.log(`Start listening port: ${app.get('port')}`);
});

module.exports = app;
