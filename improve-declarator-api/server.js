const express = require('express');
const dotenv = require('dotenv');
const path = require('path');
const { parse } = require('url');
const { getAvatar, getPoliticians } = require('./scrap');
const cors = require('cors');

const corsOptions = {
  origin: 'http://localhost',
  optionsSuccessStatus: 200,
};

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
app.use(function (req, res, next) {

  // Website you wish to allow to connect
  res.setHeader('Access-Control-Allow-Origin', '*');

  // Request methods you wish to allow
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

  // Request headers you wish to allow
  res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

  // Set to true if you need the website to include cookies in the requests sent
  // to the API (e.g. in case you use sessions)
  res.setHeader('Access-Control-Allow-Credentials', true);

  // Pass to next layer of middleware
  next();
});

app.set('port', process.env.PORT);

/**
 * Controllers
 */
app.get('/api/avatar/:id', cors(corsOptions), async (request, response) => {
  const avatar = await getAvatar(request.params.id);

  response.write(avatar);
});

app.get('/api/politicians', cors(corsOptions), async (request, response) => {
  const { query } = parse(request.url, true);

  const politicians = await getPoliticians(parseInt(query.limit, 10));

  response.json({ data: politicians });
});

/**
 * Start express server
 */
app.listen(app.get('port'), () => {
  console.log(`Start listening port: ${app.get('port')}`);
});

module.exports = app;
