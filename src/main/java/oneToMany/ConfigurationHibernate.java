package oneToMany;

import oneToOneGroupWork.AnnotatedClasses.Car;
import oneToOneGroupWork.AnnotatedClasses.Person;
import oneToOneGroupWork.AnnotatedClasses.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class ConfigurationHibernate {


    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    private static Properties properties;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Lietkabelis123");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop"); //update, create-drop

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Cart.class);
            configuration.addAnnotatedClass(Item.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }

        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

