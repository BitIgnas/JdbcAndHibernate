package oneToOneGroupWork;


import oneToOneGroupWork.AnnotatedClasses.Person;
import oneToOneGroupWork.AnnotatedClasses.Phone;
import oneToOneGroupWork.HibernateUtil.HibernateDatabaseConnector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateDatabaseConnector.getSessionFactory().openSession();
        session.beginTransaction();

        Phone samsumgA10 = new Phone();
        samsumgA10.setManufacturer("Samsung");
        samsumgA10.setModel("a10");

        Phone iphone11 = new Phone();
        iphone11.setManufacturer("Apple");
        iphone11.setModel("11");

        Phone xiaomi = new Phone();
        xiaomi.setManufacturer("Xiaomi");
        xiaomi.setModel("Redmi");

        session.save(samsumgA10);
        session.save(iphone11);
        session.save(xiaomi);

        Person person = new Person();
        person.setName("Edgaras");
        person.setCountry("Lithuania");
        person.setPhone(samsumgA10);

        Person person1 = new Person();
        person1.setName("Artur");
        person1.setCountry("Lithuania");
        person1.setPhone(xiaomi);

        Person person2 = new Person();
        person1.setName("Igor");
        person1.setCountry("Russia");
        person1.setPhone(iphone11);


        session.save(person);
        session.save(person1);
        session.save(person2);

        session.getTransaction().commit();



    }
}
