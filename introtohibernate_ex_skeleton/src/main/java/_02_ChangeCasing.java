import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Query from_Town = em.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = from_Town.getResultList();

        for (Town town : resultList) {
            String name = town.getName();
            if (name.length() <= 5) {
                String toUpper = name.toUpperCase();
                town.setName(toUpper);

                em.persist(town);
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
