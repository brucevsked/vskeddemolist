package com.vsked.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.vsked.beans.Comment;
import com.vsked.mapper.CommentMapper;

public class CommentTest {
	public static void main(String[] args) throws Exception {
		  Reader reader    = Resources.getResourceAsReader("dbconfig.xml");
		  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		  SqlSession session = sqlSessionFactory.openSession();
		  CommentMapper cm=session.getMapper(CommentMapper.class);
		  Comment c=cm.getCommentById(11);
		  System.out.println(c.getId());
		  System.out.println(c.getUserid());
		  System.out.println(c.getPictureid());
		  System.out.println(c.getContent());
		  System.out.println(c.getCreatetime());
		  System.out.println(c.getLasttime());
		 
		  session.close();

	}

}
