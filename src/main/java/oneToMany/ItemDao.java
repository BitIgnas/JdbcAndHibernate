package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class ItemDao {


    public void findAll(){
        SessionFactory sessionFactory;
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List items = session.createQuery("from Item").list();

        for (Object item  : items) {
            System.out.println(item);
        }
    }

    public void updateItemById(Long id, String name){
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "Update Item set name = ? Where id = ?";
        Query query = session.createSQLQuery(sql);
        query.setParameter(1, name);
        query.setParameter(2, id);
        int affectedRows = query.executeUpdate();
        System.out.println("Rows affected: " + affectedRows);
    }

    public void saveItem(String name, Cart cart){
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("INSERT into Item (name, cart_id) VALUES (?, ?)");
        query.setParameter(1, name);
        query.setParameter(2, cart);
        int executedRows = query.executeUpdate();
        System.out.println("Rows inserted: " + executedRows);

    }

    public void deleteItemFromCart(String name){
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("DELETE from item WHERE name = ?");
        query.setParameter(1, name);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
    }
}
