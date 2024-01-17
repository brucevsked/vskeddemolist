package com.jat.tools;

import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import javax.sql.DataSource;

/**
 * Jfinal代码生成工具
 */
public class JFinalGenerator {
    /**
     * 创建数据库连接池，获取数据库连接信息
     *
     * @return
     */
    public static DataSource getDataSource() {
        String dbHost="10.0.193.11";//数据库连接地址可以是IP或域名
        int dbHostPort=3306;//数据库连接端口号
        String dbName="jatjfinaladmin";//数据库名
        String dbUserName="root"; //数据库用户名
        String dbUserPass="root"; //数据库用户密码
        DruidPlugin druidPlugin = new DruidPlugin("jdbc:mysql://"+dbHost+":"+dbHostPort+"/"+dbName+"?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull", dbUserName, dbUserPass);
        druidPlugin.start();  //启动数据库连接池
        return druidPlugin.getDataSource();  //获取数据库连接
    }

    public static void main(String[] args) {
        // base model 所使用的包名
        String baseModelPackageName = "com.jat.model.base";
        // base model 文件保存路径
        // System.getProperty("user.dir"):获取程序当前路径
        String baseModelOutputDir = System.getProperty("user.dir") + "/src/main/java/com/jat/model/base";
        System.out.println("baseModelOutputDir文件路径：" + baseModelOutputDir);
        // model 所使用的包名 (MappingKit 默认使用的包名)
        String modelPackageName = "com.jat.model";
        // model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
        String modelOutputDir = baseModelOutputDir + "/..";
        // 创建生成器，根据数据库连接信息创建生成器
        Generator generator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        // 配置是否生成备注
        generator.setGenerateRemarks(true);
        // 设置数据库方言
        generator.setDialect(new MysqlDialect());
        // 设置是否生成链式 setter 方法
        generator.setGenerateChainSetter(true);  //or  true
        // 添加不需要生成的表名
        //generator.addExcludedTable("adv");
        // 设置是否在 Model 中生成 dao 对象
        generator.setGenerateDaoInModel(true);
        // 设置是否生成字典文件
        generator.setGenerateDataDictionary(true);
        //需要去掉的表前缀
        generator.setRemovedTableNamePrefixes("");
        // 生成
        generator.generate();
    }
}

