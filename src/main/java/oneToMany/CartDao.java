package oneToMany;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CartDao {


    public void findAll() {
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List carts = session.createQuery("from Cart").list();

        for (Object cart : carts) {
            System.out.println(cart);
        }

    }


    public void deleteCart(Long id){
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("DELETE from Cart WHERE cart_id = ?");
        query.setParameter(1, id);

        int deletedRows = query.executeUpdate();
        System.out.println("Deleted rows from carts: " + deletedRows);
    }
}
