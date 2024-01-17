package com.jat.config;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.jat.interceptor.CrossInterceptor;
import com.jat.interceptor.ExceptionInterceptor;
import com.jat.interceptor.JwtTokenInterceptor;
import com.jat.model._MappingKit;
import com.jat.pluging.JwtTokenPlugin;
import com.jat.service.UserService;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.json.JFinalJson;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByMethodRegex;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;

public class DbConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        //加载系统属性配置文件 随后可用getProperty(...)获取值
        loadPropertyFile("db.txt");//加载数据库配置文件
        constants.setLogFactory(new Slf4jLogFactory()); //绑定slf4j+log4j2
        JFinalJson.setModelAndRecordFieldNameToCamelCase(false);//Model、Record 字段名转换为驼峰格式
        constants.setDevMode(true);//使用debug模式时修改代码立即生效，不需要重启服务
        //支持Controller、Interceptor、Validator之中使用@Inject注解
        constants.setInjectDependency(true);
        //配置对超类属性中进行注入
        constants.setInjectSuperClass(true);
    }

    @Override
    public void configRoute(Routes routes) {
        //控制器包扫描
        routes.scan("com.jat.admin.api");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        //获取数据库配置信息
        String jdbcUrlString=getProperty("jdbcUrl");
        String userName=getProperty("user");
        String password=getProperty("password");
        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrlString,userName,password);
        druidPlugin.addFilter(new StatFilter()); //开启过滤
        druidPlugin.addFilter(new Slf4jLogFilter());//开启日志过滤

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);

        activeRecordPlugin.setDevMode(true);
        activeRecordPlugin.setShowSql(true);//控制台显示sql语句

        plugins.add(druidPlugin);
        plugins.add(activeRecordPlugin);
        plugins.add(new JwtTokenPlugin(UserService.me));
        _MappingKit.mapping(activeRecordPlugin);

        //加载redis插件并使用
        String cacheName=getProperty("cacheName");
        String host=getProperty("redisHost");
        int port=getPropertyToInt("redisPort");
        int timeout=10000;
        String redisPass=getProperty("redisPass");
        // 用于缓存模块的redis服务
        RedisPlugin redisPlugin = new RedisPlugin(cacheName, host, port, timeout, redisPass);
        plugins.add(redisPlugin);

    }

    @Override
    public void configInterceptor(Interceptors me) {
        //跨域处理拦截器
		me.add(new CrossInterceptor());
        me.add(new JwtTokenInterceptor());
        me.add(new TxByMethodRegex("(.*save.*|.*update.*|.*delete.*)"));
        me.add(new ExceptionInterceptor());
	}

    @Override
    public void configHandler(Handlers handlers) {

    }

    public void onStart() {
        super.onStart();
    }
}
