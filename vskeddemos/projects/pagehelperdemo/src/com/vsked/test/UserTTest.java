package com.vsked.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.vsked.bean.UserT;
import com.vsked.dao.UserTMapper;

public class UserTTest {

	public static void main(String[] args) throws Exception {
		UserTTest userTestA=new UserTTest();

		Reader reader = Resources.getResourceAsReader("dbconfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		UserTMapper um = session.getMapper(UserTMapper.class);
		
		//userTestA.testFindById(um);
		//userTestA.testFindAll(um);
		userTestA.testFindByPage(um);
		
		session.close();

	}
	
	public void testFindById(UserTMapper um){
       UserT u=um.findById(1);
	   System.out.println(u);
	}
	
	public void testFindAll(UserTMapper um){
		List<UserT> userTList = um.findAll();
		for(UserT ut: userTList){
			System.out.println(ut);
		}
	}
	
	public void testFindByPage(UserTMapper um){
		int pageNum=1;
		int pageSize=5;
		PageHelper.startPage(pageNum, pageSize);
		List<UserT> userTList = um.findAll();
		for(UserT ut: userTList){
			System.out.println(ut);
		}
	}
	
	
	

}
