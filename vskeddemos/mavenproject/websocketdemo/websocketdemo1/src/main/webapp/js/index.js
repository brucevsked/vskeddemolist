var basePath=document.getElementsByTagName('base')[0].href;

console.log(basePath.replace('http:','ws:'))
var webSocket =
      new WebSocket(basePath.replace('http:','ws:')+'websocketTest');
    webSocket.onerror = function(event) {
      onError(event)
    };
 
    webSocket.onopen = function(event) {
      onOpen(event)
    };
 
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
 
    function onMessage(event) {
      document.getElementById('messages').innerHTML
        += '<br />' + event.data;
    }
 
    function onOpen(event) {
      document.getElementById('messages').innerHTML
        = 'Connection established';
    }
 
    function onError(event) {
      alert(event.data);
    }
 
    function start() {
      webSocket.send('hello');
      return false;
    }