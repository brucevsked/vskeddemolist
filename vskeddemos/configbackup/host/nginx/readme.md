0nginx.conf nginx-1.18.0默认配置
1nginx.conf 一个nginx-1.18.0下面负载多个tomcat
2.0nginx.conf  一台服务器下面多个域名 主配置文件 定义服务器端口号与服务器组
2.1nginx.conf 一台服务器下面多个域名 辅助配置带https证书的后台接口 域名b2b2c-api.junantaikeji.com
2.2nginx.conf 一台服务器下面多个域名 辅助配置没有https证书 域名b2b2c-multishop.junantaikeji.com
2.3nginx.conf 一台服务器下面多个域名 辅助配置没有https证书 域名b2b2c-platform.junantaikeji.com
3nginx.conf 文件或图片访问测试root与alias示例
4nginx.conf 一台服务器下多个域名，无https证书 域名www.vsked.cn
5nginx.conf 去掉访问地址第一段。注意端口号！将http://127.0.0.1/prod-api/test2访问地址重写为http://127.0.0.1:8181/test2
6nginx.conf 一个服务器下添加一个新域名需要的参数