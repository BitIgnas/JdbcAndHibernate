package example4.dao;

import example4.Model.Person;
import example4.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Reikalingas funkcijoms saveikauti su duomenu baze
 */
public class PersonDao {

    public void createPerson(Person person){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }

    public Person getPerson(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Person person = session.find(Person.class, id);
            return person;
        }catch ( Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    public void deletePerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Pradendam transaction
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        //uzdarom/sukomitinam transaction
        transaction.commit();
    }

    public void updatePerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();

    }

    public List<Person> getPersonByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_person_by_name", Person.class);
        //Select * FROM person where name LIKE '%eda%'
        query = query.setParameter("name", "%" + name + "%");
        List<Person> persons = query.list();
        return persons;
    }
}
