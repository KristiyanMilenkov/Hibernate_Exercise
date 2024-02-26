import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String departmentName = "Research and Development";

        List<Employee> resultList = em.createQuery("SELECT e FROM Employee e" +
                " WHERE e.department.name = :departmentName" +
                " ORDER BY e.salary asc, e.id asc", Employee.class)
                .setParameter("departmentName", departmentName)
                .getResultList();


        for (Employee employee : resultList) {
            String format = String.format("%s %s from %s - $%f",
                    employee.getFirstName(),
                    employee.getLastName(),
                    departmentName,
                    employee.getSalary());
            System.out.println(format);
        }

        em.getTransaction().commit();
        em.close();
    }
}
