package com.vsked.test;

import org.hibernate.Session;

import com.vsked.hibernate.domain.Stock;
import com.vsked.util.HibernateSessionFactory;


public class AppTest
{   
	 public static void main( String[] args )
	    {
	        System.out.println("Hibernate + MySQL");
	        Session session =HibernateSessionFactory.getSession();
	        
	        session.beginTransaction();
	        Stock stock = new Stock();
	        
	        stock.setStockCode("3333111");
	        stock.setStockName("CCCCC");
	        
	        session.save(stock);
	        session.getTransaction().commit();
	        System.exit(0);
	        
	    }
 
}
