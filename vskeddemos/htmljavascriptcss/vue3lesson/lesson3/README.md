vite+vue3+axios
使用路由跳转页面

cd L:\git\vskeddemolist\vskeddemos\vue3lesson
npm create vite@latest
输入项目名称
lesson3
选择项目类型
vue
cd L:\git\vskeddemolist\vskeddemos\vue3lesson\lesson3
npm install


使用vscode打开文件夹lesson3
然后打开package.json选择scripts上调试即可运行当前项目
运行起来后访问下面地址即可
http://localhost:3000/

也可以使用命令方式
cd L:\git\vskeddemolist\vskeddemos\vue3lesson\lesson3
npm run dev
运行起来后访问下面地址即可
http://localhost:3000/


修改package.json添加依赖 axios
npm info axios versions
安装
npm install axios
这时候就会看到package.json中多了一句
    "axios": "^0.26.1",
说明安装成功

使用axios请求

第一步 在要使用的vue文件或js文件中导入
import axios from "axios";

第二步 在方法中调用
      axios
        .get("http://localhost:3000/index.html")
        .then(function (res) {
          console.log(res);
        })
        .catch(function (error) {
          // 请求失败处理
          console.log(error);
        });

第三步 封装整个项目请求为一个公用请求文件
如封装为
httpRequest.js

整个项目发送请求时都会引入此文件，并使用其中的公用方法









