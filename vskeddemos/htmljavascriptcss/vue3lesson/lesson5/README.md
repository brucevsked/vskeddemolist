vite+vue3+登录+跳转页+axios
使用路由跳转页面

cd L:\git\vskeddemolist\vskeddemos\htmljavascriptcss\vue3lesson
npm create vite@latest
输入项目名称
lesson5
选择项目类型
vue
cd L:\git\vskeddemolist\vskeddemos\htmljavascriptcss\vue3lesson\lesson5
npm install


使用vscode打开文件夹lesson4
然后打开package.json选择scripts上调试即可运行当前项目

也可以使用命令运行
npm run dev
运行起来后访问下面地址即可
http://127.0.0.1:5173/

也可以使用命令方式
cd L:\git\vskeddemolist\vskeddemos\htmljavascriptcss\vue3lesson\lesson4
npm run dev
运行起来后访问下面地址即可
http://127.0.0.1:5173/


修改HelloWorld.vue为login.vue
并修改login.vue内容为登录界面内容

修改App.vue文件


修改package.json添加依赖 axios
npm info axios versions
安装
npm install axios
这时候就会看到package.json中多了一句
    "axios": "^0.27.2",
说明安装成功

修改login.vue文件，添加axios请求发送代码

npm install vue-router
检查package.json中vue-router是否安装成功



运行项目时
npm i
npm run dev







