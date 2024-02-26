import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _07_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("SELECT a FROM Address a" +
                        " ORDER BY a.employees.size desc"
                        , Address.class)
                .setMaxResults(10)
               .getResultStream()
                .forEach(System.out::println);


        em.getTransaction().commit();
        em.close();
    }
}
