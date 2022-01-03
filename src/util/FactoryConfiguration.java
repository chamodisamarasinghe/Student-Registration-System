package util;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties properties=new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException("There is issue in hibernate util");
        }


          Configuration configuration =new Configuration().mergeProperties(properties).addAnnotatedClass(Student.class).addAnnotatedClass(Programme.class).addAnnotatedClass(Registration.class).addAnnotatedClass(RegisterDetail.class);
            sessionFactory = configuration.buildSessionFactory();
        }


    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null) ? factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}