/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dounia.dao;

import java.util.Properties;
import ma.dounia.model.Article;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author Dounia
 */
public class HibernateUtil {
     private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bdarticles?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "momo");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "none");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(ma.dounia.model.Article.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }  
}
