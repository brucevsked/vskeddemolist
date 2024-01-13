package com.jat;

import com.jat.config.Slf4jLogFactory;
import com.jat.interceptor.CrossInterceptor;
import com.jat.model1.Test1Jat;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.json.JFinalJson;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class DbConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        //加载系统属性配置文件 随后可用getProperty(...)获取值
        loadPropertyFile("db.txt");

        constants.setLogFactory(new Slf4jLogFactory()); //绑定slf4j+log4j2
        JFinalJson.setModelAndRecordFieldNameToCamelCase(false);//Model、Record 字段名转换为驼峰格式
        //支持Controller、Interceptor、Validator之中使用@Inject注解
        constants.setInjectDependency(true);
        //配置对超类属性中进行注入
        constants.setInjectSuperClass(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("com.jat.controller");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
//        String jdbcUrlString=getProperty("jdbcUrl");
//        String userName=getProperty("user");
//        String password=getProperty("password");
//        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrlString,userName,password);
//        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
//
//        activeRecordPlugin.setDevMode(true);
//        activeRecordPlugin.setShowSql(true);
//
//        activeRecordPlugin.addMapping("test1_jat", Test1Jat.class);//完成映射
//
//        plugins.add(druidPlugin);
//        plugins.add(activeRecordPlugin);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new CrossInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
