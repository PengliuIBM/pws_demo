var http = require('http');
var url = require('url');

HOST = null;

var host = "0.0.0.0";
var port = process.env.PORT || 3000;

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/html;charset=GBK'});
    res.write('<h1>Hello from a node app! ');
    res.write('</h1>');
    res.write('<h2>');
    res.write('Welcome to the Node.js Application! ');
    res.write('via: ' + host + ':' + port);
    res.end('</h2>');
}).listen(port, null);

console.log('Server running at http://' + host + ':' + port + '/');
