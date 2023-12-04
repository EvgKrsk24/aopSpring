package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1OneToOne_Uni {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Borisov",
//                    "Sales",777);
//            Detail detail = new Detail("Domodedovo", "8800",
//                    "Rubikon@gmail.ru");
//
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.persist(employee); // сохр employ, detail сохр авт тк есть зависимость OnetoOne-One Dir +Cascade
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//****************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail()); // получаем благодаря зависимость OnetoOne+Cascade
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//****************

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.remove(emp); // тк Cascade удаляться данные из Details

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }


    }


}
