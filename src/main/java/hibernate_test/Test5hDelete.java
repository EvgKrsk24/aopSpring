package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5hDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 8);
//            session.remove(emp);

            session.createQuery("delete Employee " +
                    "where firstName = 'Mikhail'").executeUpdate(); // executeUpdate() = delete, update ... universal


            session.getTransaction().commit(); // всегда делаем транзакци при любом типе запроса select, save, update, delete ..

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }


}
