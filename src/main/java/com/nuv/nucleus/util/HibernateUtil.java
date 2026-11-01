package com.nuv.nucleus.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Hibernate SessionFactory creation failed");
        }
    }
    public static SessionFactory getSessionFactory() { return sessionFactory; }
    public static void shutdown() { getSessionFactory().close(); }
}
