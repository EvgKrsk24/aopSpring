package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3hWhereAnd {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("from Employee") // find all
//                            .getResultList();

            List<Employee> emps = session.createQuery("from Employee " +
                            "where firstName = 'Mikhail' and salary>650")
                            .getResultList();



            for (Employee e: emps)
                System.out.println(e);

            session.getTransaction().commit(); // всегда делаем транзакци при любом типе запроса select, save, update, delete ..

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }


}
