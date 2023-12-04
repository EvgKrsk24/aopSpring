package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2hSelect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Tregulov", "Sales", 750);
            session.beginTransaction();
            session.persist(emp); //over save
//            session.getTransaction().commit();

            int myId = emp.getId(); // получение созданногго объекта
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // преобразование строки тб в объект
            session.getTransaction().commit(); // всегда делаем транзакци при любом типе запроса select, save, update, delete ..
            System.out.println(employee);


            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }


}
