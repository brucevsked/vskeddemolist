1 准备两个项目
服务提供者项目
springcloudprovider
服务调用者项目
springcloudconsumer

2 服务提供者注意点
控制层不变
yml配置文件中要写名应用名称myprovider1 这个名称调用的时候会用到
也可以在yml中开启okhttp

3服务调用者注意点
控制层注入restTemplate
注意这里远程调用的时候要调用服务名+服务地址
"http://myprovider1/service1/" + username

可以对restTemplate实现不同的技术如okhttp,httpclient等

