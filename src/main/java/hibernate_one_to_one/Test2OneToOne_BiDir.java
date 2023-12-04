package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2OneToOne_BiDir {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Chichikov",
//                    "HR",950);
//            Detail detail = new Detail("London", "+1752555",
//                    "Olega@gmail.ru");
//            employee.setEmpDetail(detail); // сохр detail для employee
//            detail.setEmployee(employee); // + сохр employee для detail тк OneToOne Bi Dir
//            session.beginTransaction();
//
//            session.persist(detail); // сохр employ, detail сохр авт тк есть зависимость OnetoOne+Cascade
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class,6);
//
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class,1);
            detail.getEmployee().setEmpDetail(null); // удаляем detail из employee, для воможности удаление чисто detail
            session.remove(detail);


            session.getTransaction().commit();
            System.out.println("Done!");



        }
        finally {
            session.close();
            factory.close();
        }


    }


}
