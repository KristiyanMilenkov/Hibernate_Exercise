import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class _04_RichEmployeesFirstNames {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE '%a%'");
        List<Employee> employees = query.getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

        em.getTransaction().commit();
        em.close();
    }
}
