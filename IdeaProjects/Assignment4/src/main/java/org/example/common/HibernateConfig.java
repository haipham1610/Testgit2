package org.example.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSession(Session session) {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public static void closeTransaction(Transaction tx) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
    }


}
