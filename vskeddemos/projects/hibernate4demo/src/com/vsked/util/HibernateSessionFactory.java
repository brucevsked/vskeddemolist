package com.vsked.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static org.hibernate.SessionFactory sessionFactory;
    private static final Configuration c=new Configuration();
    private static final StandardServiceRegistryBuilder ssr=new StandardServiceRegistryBuilder();
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static final String configFile="/hibernate.cfg.xml";

	static{
		c.configure(configFile);
		BeanMapper.initMapper(c);
        sessionFactory= c.buildSessionFactory(ssr.applySettings(c.getProperties()).build());
    }
	
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			threadLocal.set(session);
		}

        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
    
	public static void rebuildSessionFactory() {
		c.configure(configFile);
		BeanMapper.initMapper(c);
		sessionFactory =  c.buildSessionFactory(ssr.applySettings(c.getProperties()).build());
	}

}