package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4hUpdare {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);
            session.createQuery("update Employee  set salary=1000 " +
                    "where firstName = 'Mikhail'").executeUpdate();



            session.getTransaction().commit(); // всегда делаем транзакци при любом типе запроса select, save, update, delete ..

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }


}
