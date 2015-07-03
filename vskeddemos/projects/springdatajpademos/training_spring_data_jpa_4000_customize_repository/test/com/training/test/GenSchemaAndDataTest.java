package com.training.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.jpa.domain.AccountInfo;
import com.training.jpa.domain.UserInfo;


public class GenSchemaAndDataTest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
		try
        {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable e)
        {
            throw new ExceptionInInitializerError(e);
        }		
	}
	
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void generateSchema() {
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
	
	@Test
	public void geterateData(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		UserInfo user = new UserInfo();
		user.setUsername("tom");
		user.setPassword("password");
		
		AccountInfo account = new AccountInfo();
		account.setBalance(8888);
		account.setUserInfo(user);
		session.save(account);
		
		UserInfo user2 = new UserInfo();
		user2.setUsername("jobs");
		user2.setPassword("password");
		
		AccountInfo account2 = new AccountInfo();
		account2.setBalance(888888888);
		account2.setUserInfo(user2);
		session.save(account2);	
		
		session.getTransaction().commit();		
	}
	

	

	


}
