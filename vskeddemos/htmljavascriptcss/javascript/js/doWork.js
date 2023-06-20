self.addEventListener('message', function(e) {
    console.log("let's start work");
    self.postMessage(e.data);
}, false);