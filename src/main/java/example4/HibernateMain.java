package example4;

import example4.Model.Person;
import example4.dao.PersonDao;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        //HibernateUtil.getSessionFactory(); testacimas ar connection veikia
        PersonDao personDao = new PersonDao();
        //create person
        Person person = new Person(null,"Henry", "Haynes", "henry123@gmail.com", "USA");
        personDao.createPerson(person);

        //find person
        System.out.println(personDao.getPerson(1L));
        personDao.deletePerson(person);

        //again create person
        personDao.createPerson(person);
        System.out.println(personDao.getPerson(2L));
        person.setCountry("Russia");
        person.setLastName("Potter");
        personDao.updatePerson(person);
        System.out.println(personDao.getPerson(2L));

        List<Person> personList = personDao.getPersonByName("enr");
        for (Person p : personList) {
            System.out.println(p);
        }
    }
}
