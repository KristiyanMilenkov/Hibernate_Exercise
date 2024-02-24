import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String[] searchedName = scanner.nextLine().split(" ");

        Long result = em.createQuery("SELECT COUNT(e) FROM Employee e" +
                " WHERE firstName = :first_name" +
                "  and lastName = :last_name" , Long.class)
                .setParameter("first_name" , searchedName[0])
                .setParameter("last_name", searchedName[1])
                .getSingleResult();

        if (result > 0) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        em.getTransaction().commit();
    }
}
