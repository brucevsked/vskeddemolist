package com.vsked.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import com.vsked.util.DataSourceUtil;

public class TestDS {

	public static void main(String[] args) throws Exception {
		int dbType=0;
		DataSource dataSource=DataSourceUtil.getDataSource(dbType); 
		createTable(dataSource);
		initData(dataSource);
		viewData(dataSource);
		dropTable(dataSource);

	}
	
	public static void createTable(DataSource dataSource) throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append("CREATE TABLE  TestTable_T ");
		sb.append("( ");
		sb.append("USERID NUMBER PRIMARY KEY NOT NULL, ");
		sb.append("USERNAME VARCHAR2(200) NOT NULL, ");
		sb.append("PASSWORD VARCHAR2(200) NOT NULL, ");
		sb.append("CREDITS NUMBER DEFAULT 0, ");
		sb.append("LASTIP VARCHAR2(20) NOT NULL, ");
		sb.append("LASTVISIT DATE default sysdate ");
		sb.append(")");
		
		Connection conn = dataSource.getConnection();  
		Statement stmt = conn.createStatement();  
	    System.out.println(sb.toString());  
	    stmt.execute(sb.toString());  
	    stmt.close();  
	    conn.close();  
	}
	
	public static void dropTable(DataSource dataSource) throws Exception{
		Connection conn = dataSource.getConnection();  
		Statement stmt = conn.createStatement();  
	    stmt.execute("DROP TABLE TestTable_T");  
	    stmt.close();  
	    conn.close();
	}
	
	public static void initData(DataSource dataSource) throws Exception{
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		
		for(int i=0;i<100;i++){
		stmt.addBatch("insert into TestTable_T(USERID,USERNAME,PASSWORD,CREDITS,LASTIP) values("+i+",'admin"+i+"','admin"+i+"',"+(i*100)+",'127.0.0.1')");
		}
		
		stmt.executeBatch();
		stmt.close();  
	    conn.close();
	}
	
	public static void viewData(DataSource dataSource) throws Exception{
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery("select USERID,USERNAME,PASSWORD,CREDITS,LASTIP,LASTVISIT from TestTable_T");
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		
		stmt.close();  
	    conn.close();
	}

}
