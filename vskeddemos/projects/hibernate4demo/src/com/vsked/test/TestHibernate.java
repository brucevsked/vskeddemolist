package com.vsked.test;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vsked.hibernate.domain.UserT;
import com.vsked.util.HibernateSessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		Session s=HibernateSessionFactory.getSession();
		testInsert(s);
		testSelect(s);
		testQuery(s);
		System.exit(0);

	}
	
	public static void testQuery(Session s){
		// from class name
		String sql="from UserT";
		Query q=s.createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<UserT> ulist=q.list();
		
		//s.close();
		
		for(int i=0;i<ulist.size();i++){
			UserT u=ulist.get(i);
			System.out.println(u.getUserId()+"|"+u.getUserName()+"|"+u.getUserPass()+"|"+u.getLastLoginTime());
		}
		
	}
	
	public static void testSelect(Session s){
		UserT u=(UserT) s.get(UserT.class, 3);
		UserT ua=(UserT) s.load(UserT.class, 2);
		System.out.println(u.getUserName()+"||"+ua.getUserName());
	}
	
	public static void testInsert(Session s){
		UserT u=new UserT("playert","playertn","playertp",new Timestamp(System.currentTimeMillis()));
		Transaction t=s.beginTransaction();
		s.save(u);
		t.commit();
		//s.close();
	}

}
