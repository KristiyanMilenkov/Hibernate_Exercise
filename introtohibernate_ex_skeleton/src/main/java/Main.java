import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

//        Select query
//        Town town = em.find(Town.class, 1);
//        System.out.println(town.getName());

        em.getTransaction().commit();
    }
}
