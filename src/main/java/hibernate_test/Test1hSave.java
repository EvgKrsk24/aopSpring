package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1hSave {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Mikhail", "Egov", "HR", 750);
            session.beginTransaction();
            session.persist(emp); //over save
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(emp);
        }
        finally {
            factory.close();
        }


    }


}
