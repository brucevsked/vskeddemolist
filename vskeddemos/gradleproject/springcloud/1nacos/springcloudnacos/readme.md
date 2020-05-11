
0在bootstrap.yml文件中写上配置中心的地址  
并在配置中心中新建配置  
http://10.0.193.11:8848/nacos  
1我们写一个配置读取类  
com.vsked.config.MyConfig1  
注意头部要写注解  

2我们写一个控制器来读取上面的配置输出  
com.vsked.controller.TestController  

3启动项目测试一下  
com.vsked.Application  
http://127.0.0.1:8080/myconfig1
在没配置值之前取到的值都会是空的  
打开nacos控制台，依次点击：配置管理->配置列表，进入配置列表界面。  
新增配置  
点击右侧+，新建配置  
在 Nacos Spring Cloud 中，DataId的完整格式如下  
${prefix}-${spring.profile.active}.${file-extension}  
在Nacos-Server中新建配置，其中Data ID它的定义规则是：${prefix}-${spring.profile.active}.${file-extension}

prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix 来配置。  
spring.profile.active 即为当前环境对应的 profile，可以通过配置项 spring.profile.active 来配置。  
file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。  
注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}  
http://10.0.193.11:8848/nacos/#中  
新建的配置格式如下  
myproduct1-mysql.yml    
配置格式选YAML  
system:
  myconfig:
    databaseusername: root
    databaseuserpass: rootpass
    databasecount: 9

配置完成后点发布  

