customElements.define('menu-list',
  	class extends HTMLElement {
  	  	constructor() {
  	    super();
  	    var template = document.getElementById('menu-box').content;
  	    const shadowRoot = this.attachShadow({mode: 'open'}).appendChild(template.cloneNode(true));
  	}
})