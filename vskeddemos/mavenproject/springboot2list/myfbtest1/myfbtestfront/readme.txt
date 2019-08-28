

纯前端项目
测试时需要放入tomcat或nginx

如将src/main/resources/front文件夹放入tomcat的webapp目录中


http://localhost:8080/front/templates/SysUserLogin.html

如果不喜欢这种不改变地址栏url的方式
a可以使用javascript修改地址栏
b通过跳转页面在请求地址里带上参数 跳到到界面以后使用js解析出url中token即可