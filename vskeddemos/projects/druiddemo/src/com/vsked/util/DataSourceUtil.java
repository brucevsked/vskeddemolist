package com.vsked.util;

import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Properties;  
  
import javax.sql.DataSource;  
  
import com.alibaba.druid.pool.DruidDataSourceFactory;  
  
/** 
 * The Class DataSourceUtil. 
 */  
public class DataSourceUtil {  
  
    /** 使用配置文件构建Druid数据源. */  
    public static final int DRUID_MYSQL_SOURCE = 0;  
  
    /** 使用配置文件构建Druid数据源. */  
    public static final int DRUID_MYSQL_SOURCE2 = 1;  
  
    /** 使用配置文件构建Dbcp数据源. */  
    public static final int DBCP_SOURCE = 4;  
    public static String confile = "jdbc.properties";  
    public static Properties p = null;  
  
    static {  
        p = new Properties();  
        InputStream inputStream = null;  
        try {  
            //java应用  
            confile = DataSourceUtil.class.getClassLoader().getResource("").getPath()+"../" + confile;  
            System.out.println(confile);  
            File file = new File(confile);  
            inputStream = new BufferedInputStream(new FileInputStream(file));  
            p.load(inputStream);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (inputStream != null) {  
                    inputStream.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * 根据类型获取数据源 
     *  
     * @param sourceType 
     *            数据源类型 
     * @return druid或者dbcp数据源 
     * @throws Exception 
     *             the exception 
     */  
    public static final DataSource getDataSource(int sourceType) throws Exception {  
        DataSource dataSource = null;  
        switch (sourceType) {  
        case DRUID_MYSQL_SOURCE:  
            dataSource = DruidDataSourceFactory.createDataSource(p);  
            break;  
        case DRUID_MYSQL_SOURCE2:  
            dataSource = DruidDataSourceFactory.createDataSource(p);  
            break;  
        case DBCP_SOURCE:  
            // dataSource = BasicDataSourceFactory.createDataSource(  
            // MySqlConfigProperty.getInstance().getProperties());  
            break;  
        }  
        return dataSource;  
    }  
}  
