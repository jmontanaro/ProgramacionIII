var express = require('express')
var app = express()
var bodyParser = require('body-parser');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', function (req, res) {
  res.send('Invocaron el Metodo GET');
  res.json(req.body);
  console.log(req.body);
})

app.post('/', function (req, res) {
  res.json(req.body);
  console.log(req.body);
})

var server = app.listen(80, function () {

  var host = server.address().address
  var port = server.address().port

  console.log('Example app listening at http://%s:%s', host, port)

