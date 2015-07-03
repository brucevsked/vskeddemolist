package com.vsked.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vsked.beans.Logs;

public class LogsTest {

	public static void main(String[] args) throws Exception {
		  Reader reader    = Resources.getResourceAsReader("dbconfig.xml");
		  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		  SqlSession session = sqlSessionFactory.openSession();
		 
		  Logs sr=session.selectOne("com.vsked.beans.LogsMapper.selectLogsByID",325);
		  System.out.println(sr.getId());
		  System.out.println(sr.getLogName());
		  System.out.println(sr.getLogDate());
		  System.out.println(sr.getTypeId());
		  System.out.println(sr.getUserId());
		 
		  session.close();

	}

}
