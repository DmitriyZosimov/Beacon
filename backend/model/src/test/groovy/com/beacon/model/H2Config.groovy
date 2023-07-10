package com.beacon.model

import com.beacon.model.order.Task
import jdk.internal.reflect.Reflection
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.Environment
import org.hibernate.service.ServiceRegistry
import org.reflections.Reflections

public class H2Config {
    private static Session session

    public static Session getSession() {
        if (session != null) {
            return session
        } else {
            Configuration configuration = new Configuration()

            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.h2.Driver");
            settings.put(Environment.URL, "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=true");
            settings.put(Environment.USER, "sa");
            settings.put(Environment.PASS, "");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

            settings.put(Environment.SHOW_SQL, "true")

//            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "create-drop")

            configuration.setProperties(settings)

            Reflections reflections = new Reflections("com.beacon.model")
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
            for(Class<?> clazz : classes) {
                configuration.addAnnotatedClass(clazz);
            }

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            session = sessionFactory.openSession()
            return session
        }
    }

}
