package com.vsked.test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jodd.db.DbQuery;
import jodd.db.DbSession;
import jodd.db.QueryMapper;
import jodd.db.connection.ConnectionProvider;
import jodd.db.connection.DriverManagerConnectionProvider;
import jodd.db.oom.DbOomQuery;

import org.junit.Test;

import static org.junit.Assert.*;

public class DboomTest {
	
	
    public void connectionTest(){
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull";
		String username="test";
		String password="test";
		ConnectionProvider mysqlProvider=new DriverManagerConnectionProvider(driverClass, url, username, password);
		DbSession session = new DbSession(mysqlProvider);
		System.out.println(session);
		assertNotNull(session);
    }
    
	public void selectTest(){
		try{
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull";
		String username="root";
		String password="Y4yhl9tbf110";
		ConnectionProvider mysqlProvider=new DriverManagerConnectionProvider(driverClass, url, username, password);
		DbSession session = new DbSession(mysqlProvider);
		String selectSql="select * from mysqlTestTableA1";
		DbQuery selectQuery=new DbQuery(session, selectSql);
		ResultSet selectRs=selectQuery.execute();
		List<Map<String, String>> dataList=new LinkedList<Map<String,String>>();
		while(selectRs.next()){
			Map<String, String> dataMap=new HashMap<String, String>();
			ResultSetMetaData selectRsm=selectRs.getMetaData();
			for(int i=1;i<selectRsm.getColumnCount();i++){
				dataMap.put(selectRsm.getColumnName(i), selectRs.getString(i));
			}
			dataList.add(dataMap);
		}
		System.out.println(dataList);
		selectQuery.closeResultSet(selectRs);
		selectQuery.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
    
    
}
