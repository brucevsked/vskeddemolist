
单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181

http://127.0.0.1:8181/test2

http://127.0.0.1/prod-api/test2

http://127.0.0.1/prod-api/profile/images/tiding.png


第一步，在主应用开启任务计划  
@EnableScheduling

示例：  
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})  
@EnableScheduling  
public class Application {  
	
	public static void main(String[] args) {  
		SpringApplication.run(Application.class, args);  
	}  
	
}  


第二步编写任务计划类  

@Component  
public class TaskList {  

    private static final Logger log = LoggerFactory.getLogger(TaskList.class);  

    @Scheduled(cron = "0/5 * * * * ?")  
    public void task1(){  
        try {  
            log.info("task start at {}   task name is :{}",new Date(),Thread.currentThread().getName());  
            Thread.sleep(10000);  
        } catch (InterruptedException e) {  
            log.error("task error",e);  
        }  
        log.info("---------------------------task end at {}, task name is:{}",new Date(),Thread.currentThread().getName());  

    }  
}  


