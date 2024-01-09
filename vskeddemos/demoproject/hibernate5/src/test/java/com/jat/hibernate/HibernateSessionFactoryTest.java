package com.jat.hibernate;

import com.jat.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;

public class HibernateSessionFactoryTest {

    private static final Logger log = LoggerFactory.getLogger(HibernateSessionFactoryTest.class);

    @Test
    public void testSessionFactory(){
        SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String querySql="from Student"; //from class
        Query studentQuery=session.createQuery(querySql);
        List<Student> studentList= studentQuery.list();
        for(Student student:studentList){
            log.info(student.toString());
        }

        session.getTransaction().commit();
        session.close();

    }
}
