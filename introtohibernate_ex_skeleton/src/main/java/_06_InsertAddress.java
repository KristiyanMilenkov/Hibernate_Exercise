import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_InsertAddress {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String addressName = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressName);
        em.persist(address);

        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        em.createQuery("UPDATE Employee e" +
                                " SET e.address = :address" +
                                " WHERE e.lastName = :name")
                .setParameter("name", lastName)
                .setParameter("address", address)
                .executeUpdate();


        em.getTransaction().commit();
        em.close();
    }
}
