

测试地址
http://localhost:80/index.html

第一步添加websocket支持包
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-websocket</artifactId>
</dependency>

第二步启用websocket支持 @EnableWebSocket
package com.vsked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		// 解决headless环境问题
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(Application.class, args);
	}

}

第三步端点配置文件
package com.vsked.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebsocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

第四步，编写websocket服务端处理，并配置上spring组件扫描(@ServerEndpoint 配置 和 @Component)
