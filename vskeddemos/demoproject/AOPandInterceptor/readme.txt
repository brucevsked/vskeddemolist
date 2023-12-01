

base1s

运行前记得检查数据库IP与连接密码

http://127.0.0.1:8181/

http://127.0.0.1:8181/session?token=mytokenabcyellowbook
http://127.0.0.1:8181/session?token=mytokenabcyellowbook&id=1


可以看出运行顺序为：
filter -> Interceptor(preHandle) ->aspect  ->  Interceptor(postHandle ) -> filter 
interceptor 基于反射机制
可以获取被影响的类
可以获取被影响的方法
可以获取被影响的controller的请求和响应
aop 基于代理
可以获取被影响的类
可以获取被影响的方法
可以获取被影响的方法的参数

结论
interceptor验证权限，这样就不必再深入服务器资源
interceptor日志拦截，这样就不必再深入服务器资源

aop暂时先不用，后期如果有合适场景再作深入


--------------------------------------------------------------------------------
AOP用法
第一步引入Aop依赖

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
		</dependency>

第二步，包扫描添加类所在包
@ComponentScan({"com.vsked.log"})

第三步，将两个类复制到所在包里
也就是com.vsked.aop包里
MDCAop.java
MDCTool.java

第四步，修改MDCAop.java拦截点，就是前台到后台的入口点一般是controller类所在包
@Pointcut("execution(public * com..*.controller..*.*(..))")

这里的controller里放的就全是控制器

--------------------------------------------------------------------------------
Interceptor用法

先准备一个拦截器
com.vsked.interceptor.ProjectInterceptor

再写一个配置文件注册这个拦截器
com.vsked.config.ProjectWebMvcConfigurer
    /**
     * 注册项目拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new ProjectInterceptor());
        registration.addPathPatterns("/**");//所有路径都被拦截
        registration.excludePathPatterns("/session");//不拦截的地址
        registration.excludePathPatterns("/**.ico");//不拦截的地址
    }
    
    
--------------------------------------------------------------------------------
2020-11-30 at 14:42:20 CST traceId:[] TRACE com.vsked.interceptor.ProjectInterceptor 27 preHandle - 进入拦截器 preHandle
2020-11-30 at 14:42:20 CST traceId:[] DEBUG com.vsked.interceptor.ProjectInterceptor 31 preHandle - token in Interceptor:mytokenabcyellowbook666
2020-11-30 at 14:42:20 CST traceId:[] DEBUG com.vsked.interceptor.ProjectInterceptor 34 preHandle - 当前访问路径:/session
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] INFO  com.vsked.aop.SessionAop 28 before -  enter before
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] INFO  com.vsked.aop.SessionAop 33 before - mytokenabcyellowbook666
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] INFO  com.vsked.auth.web.SessionController 23 createSession - create session ok in controller
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] INFO  com.vsked.auth.application.service.SessionApplicationService 15 createSession - create session ok in service
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] DEBUG com.vsked.auth.application.service.SessionApplicationService 16 createSession - mytokenabcyellowbook666
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] DEBUG com.vsked.aop.PerformenceMonitor 36 doAround - {class com.vsked.auth.application.service.SessionApplicationService.createSession}:{0s}
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] INFO  com.vsked.aop.SessionAop 38 afterReturning -  after return
2020-11-30 at 14:42:20 CST traceId:[1888888888_UoYA64iLBF8MTpKH] DEBUG com.vsked.aop.PerformenceMonitor 36 doAround - {class com.vsked.auth.web.SessionController.createSession}:{0s}
2020-11-30 at 14:42:20 CST traceId:[] TRACE com.vsked.interceptor.ProjectInterceptor 90 postHandle - 进入拦截器 postHandle
2020-11-30 at 14:42:20 CST traceId:[] TRACE com.vsked.interceptor.ProjectInterceptor 101 afterCompletion - 进入拦截器 afterCompletion
