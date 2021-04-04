package oneToOne;

import org.hibernate.Session;

public class OneToOneMain {
    public static void main(String[] args) {
        Session session = HibernateDatabaseConnector.getSessionFactory().openSession();
        session.beginTransaction();

        Book book = new Book();
        book.setTitle("Lord of the rings");

        //session.save(book); first set book if we dont have cascade type all

        Owner owner = new Owner();
        owner.setCountry("Latvia");
        owner.setName("Jefferson");
        owner.setBook(book); //set book to owner

        session.save(owner); //save owner
        //session.delete(owner);

        session.getTransaction().commit();

        Owner ownerFromDB = session.find(Owner.class, 1L);
        System.out.println(ownerFromDB);
    }
}
