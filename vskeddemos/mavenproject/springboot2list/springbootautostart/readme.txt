使用spring boot2自动启动几种方式
CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调（类似开机自启动）。

区别在于接收的参数不一样。CommandLineRunner的参数是最原始的参数，没有做任何处理。ApplicationRunner的参数是ApplicationArguments，是对原始参数做了进一步的封装。

ApplicationArguments是对参数（main方法）做了进一步的处理，可以解析--name=value的，我们就可以通过name来获取value（而CommandLineRunner只是获取--name=value）

使用 @PostConstruct 注解同样可以帮助我们完成资源的初始化操作，前提是这些初始化操作不需要依赖于其它Spring beans的初始化工作。

InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，在初始化bean的时候都会执行该方法。
————————————————
版权声明：本文为CSDN博主「QC班长」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_35624642/article/details/86676333

1、实现CommandLineRunner接口

2、实现ApplicationRunner接口

3、实现ApplicationListener接口

4、使用@PostConstruct 注解

5、实现InitializingBean接口


6、应用启动类添加任务注解
@EnableScheduling
@ComponentScan({"com.vsked.autostart","com.vsked.task"})
再编写一个类 放到com.vsked.task包里面
package com.vsked.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
	
	private static final Logger log = LoggerFactory.getLogger(MyTask.class);
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void cleanLog1DataTask() {
		log.info("one minute|"+new Date()+"|");
	}
	
	@Scheduled(cron = "*/10 * * * * ?")
	public void cleanLog2DataTask() {
		log.info("ten seconds|"+new Date()+"|");
	}

}
