package forPractice.work3;

import example4.Model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileNotFoundException;

public class EmployeeDao {

    public static Session session;
    public static Transaction transaction;

    public void createEmployee(Employee employee) throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();

    }

    public  Employee findEmployeeByID(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            return  employee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
