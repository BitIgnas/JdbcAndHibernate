package oneToMany;

import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OneToManyMain {
    public static void main(String[] args) {
        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        session.beginTransaction();

        Cart cart = new Cart();
        Cart pcCart = new Cart();

        Item bananas = new Item();
        bananas.setName("Bananas");
        bananas.setCart(cart);

        Item apple = new Item();
        apple.setName("apple");
        apple.setCart(cart);

        Item mouse = new Item();
        mouse.setName("Corsair");
        mouse.setCart(pcCart);

        Item monitor = new Item();
        monitor.setName("Samsung");
        monitor.setCart(pcCart);

        session.save(cart);
        session.save(pcCart);


        session.save(bananas);
        session.save(apple);
        session.save(mouse);
        session.save(monitor);
        session.getTransaction().commit();

        CartDao cartDao = new CartDao();
        cartDao.findAll();

        ItemDao itemDao = new ItemDao();
        itemDao.updateItemById(1L, "Corsair");
        itemDao.saveItem("Nvidia", pcCart);
        itemDao.findAll();

        itemDao.deleteItemFromCart("Samsung");
        cartDao.deleteCart(2L);







    }
}
