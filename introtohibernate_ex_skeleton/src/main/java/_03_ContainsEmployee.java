import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        List<String> resultList = em.createQuery("SELECT e.firstName FROM Employee e" +
                        " WHERE e.salary>50000", String.class)
                .getResultList();


        for (String result : resultList) {
            System.out.println(result);
        }
        em.getTransaction().commit();
        em.close();
    }
}
