package forPractice.work2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ExecutingService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("org.hibernate.project.jpa");
    private static EntityManager entityManager = null;
    private static EntityTransaction entityTransaction = null;
    public static EntityManager createEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void addBank(Bank bank) {
        entityManager = createEntityManager();

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            bank.setId(bank.getId());
            bank.setBankName(bank.getBankName());
            bank.setSerialNumber(bank.getSerialNumber());
            bank.setBankCountry(bank.getBankCountry());
            entityManager.persist(bank);
            entityManager.getTransaction().commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public static void updateBankName(Bank bank, String name) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();



            bank.setBankName(name);

            entityManager.getTransaction().commit();
            System.out.println("Updated bank name: " + bank.getBankName());

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}

