package com.jat.test;

import com.jat.config.Slf4jLogFactory;
import com.jat.model._MappingKit;
import com.jfinal.config.Constants;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.json.JFinalJson;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class JfinalTesgNgBaseTest {

    static DruidPlugin druidPlugin=null;
    static ActiveRecordPlugin activeRecordPlugin=null;
    private Constants constants;
    private Plugins plugins;

    /**
     * 通过配置类启动jfinal插件等
     */
    @BeforeTest
    public void initConfig() {
        try {
            String configClass = "com.jat.config.DbConfig";//config类的完整路径
            Class<?> clazz = Class.forName(configClass);
            JFinalConfig jfinalConfig = (JFinalConfig) clazz.newInstance();

            if(druidPlugin==null){
                PropKit.use("db.txt"); //dbfile

                String jdbcUrlString=PropKit.get("jdbcUrl");
                String userName=PropKit.get("user");
                String password=PropKit.get("password");
                druidPlugin = new DruidPlugin(jdbcUrlString,userName,password);
                druidPlugin.start();
            }

            if(activeRecordPlugin==null){
                activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);

                activeRecordPlugin.setDevMode(true);
                activeRecordPlugin.setShowSql(true);
                //-------------这里记得单元测试添加表映射！
                _MappingKit.mapping(activeRecordPlugin);//完成映射
                activeRecordPlugin.start();
            }

            constants = new Constants();
            constants.setLogFactory(new Slf4jLogFactory()); //绑定slf4j+log4j2

            JFinalJson.setModelAndRecordFieldNameToCamelCase();//Model、Record 字段名转换为驼峰格式
            jfinalConfig.configConstant(constants);

            System.out.println("\n==JunitFinalTest Start==================\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止jfinal插件
     */
    @AfterTest
    public void endConfig() {
        System.out.println("\n==JunitFinalTest End====================");
        if (activeRecordPlugin != null) {
            activeRecordPlugin.stop();
        }
        if(druidPlugin!=null){
            druidPlugin.stop();
        }
    }

}
