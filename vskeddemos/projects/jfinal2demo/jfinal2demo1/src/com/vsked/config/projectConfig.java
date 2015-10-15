package com.vsked.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.vsked.controller.IndexController;
import com.vsked.controller.UserController;
import com.vsked.entity.User;

public class projectConfig extends JFinalConfig{

	public void configConstant(Constants c) {
		 //加载系统属性配置文件 随后可用getProperty(...)获取值
        loadPropertyFile("systemConfig.txt");
        //设置开发模式
        c.setDevMode(getPropertyToBoolean("devMode", true));
        //设置视图类型为Jsp，否则默认为FreeMarker
        c.setViewType(ViewType.JSP);

	}
	
	public void configRoute(Routes r) {
		//第三个参数为该Controller的视图存放路径
		r.add("/",IndexController.class,"/");
		r.add("/user",UserController.class,"/");
	}
	
	public void configInterceptor(Interceptors a) {	}

	public void configPlugin(Plugins p) { 
		/**
         * 配置Mysql支持
         */
        //配置c3p0数据库连接池插件
        C3p0Plugin cp = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        p.add(cp);

        //配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        arp.setShowSql(true);
        p.add(arp);

        //映射表到模型
        arp.addMapping("userT","uId", User.class);


        /**
         * 配置Oracle支持
         */
        //配置c3p0数据库连接池插件
		/*
        C3p0Plugin cp = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"),getProperty("jdbcDriver")); 
        //配置Oracle驱动
        cp.setDriverClass(getProperty("jdbcDriver"));
        me.add(cp);

        //配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        arp.setShowSql(true);
        me.add(arp);

        //配置Oracle方言
        arp.setDialect(new OracleDialect());

        //配置属性名（字段名）大小写不敏感容器工厂
        arp.setContainerFactory(new CaseInsensitiveContainerFactory());

        //映射表到模型（我在Oracle数据库中建的表是这个表名）
        arp.addMapping("userT","uId", User.class);
        */
	}

	public void configHandler(Handlers h) {	}

}
