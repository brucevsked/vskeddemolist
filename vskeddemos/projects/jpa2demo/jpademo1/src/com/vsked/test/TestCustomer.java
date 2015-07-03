package com.vsked.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vsked.bean.Customer;


public class TestCustomer {
   public static void main( String[] args ) {
   	TestCustomer tc=new TestCustomer();
   	tc.findAllCustomer();
   }
   
   public void createCustomer(){
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "vskjpaunit" );
	   EntityManager em = emf.createEntityManager( );
	   em.getTransaction( ).begin( );
	   Customer c=new Customer("umbrella corporation","umbrella",100);
	   em.persist( c );
	   em.getTransaction( ).commit( );
	   em.close( );
	   emf.close( );	   
   }
   
   public void deleteCustomer(){
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "vskjpaunit" );
	   EntityManager em = emf.createEntityManager( );
	   em.getTransaction( ).begin( );
	   Customer c=em.find(Customer.class,4);
	   em.remove(c);
	   em.getTransaction( ).commit( );
	   em.close( );
	   emf.close( );	   
   }
   
   public void updateCustomer(){
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "vskjpaunit" );
	   EntityManager em = emf.createEntityManager( );
	   em.getTransaction( ).begin( );
	   	
	   Customer c=em.find(Customer.class, 2);
	   
	   c.setCustomerName("welecome come to new world");
	   c.setCustomerShortName("hello world");
	   em.getTransaction( ).commit( );
	   	
	   em.close( );
	   emf.close( );	   
   }
   
   public void findCustomer(){
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "vskjpaunit" );
	   EntityManager em = emf.createEntityManager( );
	   	
	   Customer c=em.find(Customer.class, 1);
	   System.out.println(c);
	   em.close( );
	   emf.close( );	   
   }
   
   public void findAllCustomer(){
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "vskjpaunit" );
	   EntityManager em = emf.createEntityManager( );
	   	
	   List<Customer> cList=em.createQuery("from Customer", Customer.class).getResultList();
	   for(Customer c:cList){
		   System.out.println(c);
	   }
	   em.close( );
	   emf.close( );	   
   }
}

