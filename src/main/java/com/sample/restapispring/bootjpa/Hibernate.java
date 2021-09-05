package com.sample.restapispring.bootjpa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.module.Configuration;

public class Hibernate {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make the exception's log, as it might be failed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

        public static Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            reconnect();
        }
        return session;
    }

    private static void reconnect() throws HibernateException {
        buildSessionFactory();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
