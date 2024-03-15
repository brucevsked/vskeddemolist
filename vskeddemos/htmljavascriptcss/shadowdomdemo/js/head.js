class HeadBox extends HTMLElement {
  constructor() {
    super();

    const shadow = this.attachShadow({mode: 'open'});

    const head = document.createElement('header');
    head.setAttribute('class', 'head');

    const userName = document.createElement('div');
    userName.setAttribute('class', 'user-name');

    const text = this.getAttribute('data-text');
    userName.textContent = text;

    const style = document.createElement('style');
    console.log(style.isConnected);

    style.textContent = `
      header{
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 50px;
            line-height: 50px;
            background-color: #fff;
            box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
            color: #333;
            text-align: right;
            padding-right: 5%;
            box-sizing: border-box;
            z-index:999;
        }
    `;

    shadow.appendChild(style);
    console.log(style.isConnected);
    shadow.appendChild(head);
    head.appendChild(userName);
  }
}

customElements.define('head-box', HeadBox);
