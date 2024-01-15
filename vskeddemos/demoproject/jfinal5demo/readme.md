
jfinal+slf4j+log4j2+druid数据库连接池+跨域+字段下划线转驼峰


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1
http://127.0.0.1/test
http://127.0.0.1/test/config
http://127.0.0.1/test/jsonLetter
http://127.0.0.1/test/save2
http://127.0.0.1/test2
http://127.0.0.1/test2/flow1Api
http://127.0.0.1/test2/test1


http://192.168.3.121/test

post
http://127.0.0.1/test/mypost
id
name
第一步建表
test2a
第二步，在model包里添加类，对应表名
Test2a extends Model<Test2a>

第三步，写控制器com.jat.controller
Test2Controller extends Controller

要继承Controller
查数据库时候用Db.find
--------------------------------------------------------------------------------
slf4j整合

添加pom依赖

		<log4j.version>2.17.2</log4j.version>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>${log4j.version}</version>
		</dependency>

编写 log4j2.xml 放到resources目录

添加 Slf4jLog 类到对应目录
package com.jat.config;

import com.jfinal.log.Log;

public class Slf4jLog extends Log {
    private org.slf4j.Logger log;

    Slf4jLog(Class<?> clazz) {
        log = org.slf4j.LoggerFactory.getLogger(clazz);
    }

    Slf4jLog(String name) {
        log = org.slf4j.LoggerFactory.getLogger(name);
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void debug(String message, Throwable t) {
        log.debug(message, t);
    }

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void info(String message, Throwable t) {
        log.info(message, t);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }

    @Override
    public void warn(String message, Throwable t) {
        log.warn(message, t);
    }

    @Override
    public void error(String message) {
        log.error(message);
    }

    @Override
    public void error(String message, Throwable t) {
        log.error(message, t);
    }

    @Override
    public void fatal(String message) {
        log.error("fatal_"+message);
    }

    @Override
    public void fatal(String message, Throwable t) {
        log.error("fatal_"+message, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    @Override
    public boolean isFatalEnabled() {
        return false;
    }
}


添加 Slf4jLogFactory 类到对应目录
package com.jat.config;

import com.jfinal.log.ILogFactory;
import com.jfinal.log.Log;

public class Slf4jLogFactory implements ILogFactory {
    @Override
    public Log getLog(Class<?> clazz) {
        return new Slf4jLog(clazz);
    }

    @Override
    public Log getLog(String name) {
        return new Slf4jLog(name);
    }
}

修改配置加载类
    @Override
    public void configConstant(Constants constants) {
        constants.setLogFactory(new Slf4jLogFactory()); //绑定slf4j+log4j2
    }
--------------------------------------------------------------------------------
fastjson整合 使用fastjson作为默认json转换器，不推荐
    public void configConstant(Constants constants) {
        constants.setJsonFactory(new FastJsonFactory()); //使用FastJson处理json解决输出字段变小写问题
    }
--------------------------------------------------------------------------------

跨域解决方案
先添加拦截器
CrossInterceptor

再将拦截器配置到
DbConfig中 public void configInterceptor(Interceptors interceptors) 方法内添加

interceptors.add(new CrossInterceptor());
--------------------------------------------------------------------------------
下划线转驼峰命名
DbConfig中public void configConstant(Constants constants) 方法内添加
/**
*配置将 Model、Record 字段名转换为驼峰格式
*toLowerCaseAnyway 参数的含义：
*1：true 值无条件将字段先转换成小写字母。适用于 oracle 这类字段名是大写字母的数据库
*2：false 值只在出现下划线时将字段转换成小写字母。适用于 mysql 这类字段名是小写字母的数据库
*/
JFinalJson.setModelAndRecordFieldNameToCamelCase(false);


--------------------------------------------------------------------------------
打成可执行的jar包
添加依赖打包插件

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-assembly-plugin</artifactId>
				<version>2.5.2</version>
				<configuration>
					<archive>
						<manifest>
							<mainClass>com.jat.Application</mainClass>
						</manifest>
					</archive>
					<descriptorRefs>
						<descriptorRef>jar-with-dependencies</descriptorRef>
					</descriptorRefs>
				</configuration>
			</plugin>
单独打依赖包
mvn package assembly:single
java -cp jfinal5demo-1.0.jar com.jat.Application
--------------------------------------------------------------------------------
读取配置文件
Prop prop= PropKit.use("db.txt");
String jdbcUrl=prop.get("jdbcUrl");
--------------------------------------------------------------------------------
分页示例
不带查询条件
        int pageIndex=getParaToInt("pageIndex"); //当前第几页
        int pageSize=getParaToInt("pageSize"); //每页显示多少条
        //pageTotal 总条数
        Page pageData=ktvDao.paginate(pageIndex,pageSize,"select * ","from ktv");
带查询条件
        int pageIndex=getParaToInt("pageIndex"); //当前第几页
        int pageSize=getParaToInt("pageSize"); //每页显示多少条
        String ktvName=getPara("ktvName");
        ktvName=ktvName==null?"":ktvName;
        //pageTotal 总条数
        Page pageData=ktvDao.paginate(pageIndex,pageSize,"select *","from ktv where `name` like ?","%"+ktvName+"%");
  
自定义分页查询，有多个select时：
方案① 
tbArticles = tbArticleDao.paginate(pageIndex, pageSize, "select a.*, (case when b.sys_user_id is NULL then 0 else 1 end) mylike ",
						"from tb_article_nznf a left join sys_user_like b on a.id=b.article_nznf_id and  b.sys_user_id =?  ORDER BY id DESC ", sysUserId);
						
方案②	
tbArticles = tbArticleDao.paginateByFullSql(pageIndex, pageSize, "select count((select count(1) from sys_user_like where sys_user_id = ? and id = n.id))  from tb_article_nznf n", "select n.*,(select count(1) from sys_user_like where sys_user_id = ? and article_nznf_id = n.id) AS mylike from tb_article_nznf n", sysUserId);
--------------------------------------------------------------------------------
解决循环插入时，自增字段处理
        for(int i=0;i<20;i++){
            Test1Jat s1=new Test1Jat();
            s1.setId(null); //将自增长字段设置为null可以解决批量插入主键重复问题
            s1.setName("myname"+i);
            s1.save();
        }
--------------------------------------------------------------------------------
in查询解决方案
 List<String> resourceIds=user.getForces();
        StringBuffer sb=new StringBuffer();
        for(String resourceId:resourceIds){
            sb.append(resourceId);
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        List<Resource> resources=Resource.dao.find("select * from resource a where a.id in("+sb.toString()+")");
--------------------------------------------------------------------------------
在控制层使用依赖注入
第一步 开启框架依赖注入
public void configConstant(Constants constants) {
        //支持Controller、Interceptor、Validator之中使用@Inject注解
        constants.setInjectDependency(true);
        //配置对超类属性中进行注入
        constants.setInjectSuperClass(true);
第二步 声明一个服务类

public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    public void createUser(){
        log.info("you has create the user");
    }
}

第三步 控制层或其他层使用
    @Inject
    MyService myService;

    public void t1(){
        //第三步，调用注入类的相关方法
        myService.createUser();
        renderHtml("test1 ok");
    }
--------------------------------------------------------------------------------
全局异常拦截
添加全局
package com.jat.interceptor;

import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class ExceptionInterceptor implements Interceptor {
	private static final Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);
	public void intercept(Invocation ai) {

		try {
			ai.invoke();
		} catch (Exception e) {
			log.error("全局异常：", e);
			Controller c = ai.getController();
			String errorResponse=new Response(500,"操作异常:"+e.toString())+"";
			c.renderError(500,errorResponse);
		}

	}
}

在配置类中添加全局异常配置
    public void configInterceptor(Interceptors me) {
        me.add(new ExceptionInterceptor());
	}
--------------------------------------------------------------------------------
调试时热加载，不需要重启更新修改的java代码(idea版本)
打开项目的开发模式
    public void configConstant(Constants constants) {
        constants.setDevMode(true);//使用debug模式时修改代码立即生效，不需要重启服务
    }
设置运行主类的配置

idea设置(开启自动编译)
File-Settings-build,execution,deployment->Compiler->Build Project automatically打对号
File-Settings-Advaced Settings-Allow auto-make to start even if developed application is currently running
CTRL + SHIFT + A 选择Registry
compile.document.save.trigger.delay 设置为100
compile.automake.save.trigger.delay 设置为100
--------------------------------------------------------------------------------
打印执行的sql语句与结果到日志中 需要配合slf4j整合与druid数据库连接池插件

    public void configPlugin(Plugins plugins) {
        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrlString,userName,password);
        druidPlugin.addFilter(new StatFilter()); //开启过滤
        druidPlugin.addFilter(new Slf4jLogFilter());//开启日志过滤

--------------------------------------------------------------------------------
复合主键查找与删除

//同时指定复合主键值即可查找记录 
UserRole.dao.findById(123, 456);

//同时指定复合主键值即可删除记录 
UserRole.dao.deleteById(123, 456);
--------------------------------------------------------------------------------
批量插入
List<Test1Jat> dataList=new LinkedList<>();
for(int i=3;i<10;i++){
dataList.add(new Test1Jat().set("name","myNameIs"+i).set("age",i+5));
}
int rs[]=Db.batchSave(dataList,dataList.size());
log.info("{}",rs);
--------------------------------------------------------------------------------
启动完成后自动执行与关闭前执行
在继承JFinalConfig的类中如
public class DbConfig extends JFinalConfig 
启动后执行添加方法
    public void onStart(){
        log.debug("----------jfinal 新版本jfinal 3.6 版本之后启动完成后执行-------------------");
    }


关闭前执行添加方法
    public void onStop(){
        log.debug("----------jfinal 新版本jfinal 3.6 版本之后停止前执行-------------------");
    }

--------------------------------------------------------------------------------