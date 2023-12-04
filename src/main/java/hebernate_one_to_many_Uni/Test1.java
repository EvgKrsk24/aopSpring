package hebernate_one_to_many_Uni;


import hebernate_one_to_many_Uni.entity.Department;
import hebernate_one_to_many_Uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

//            session = factory.getCurrentSession();
//            Department dep = new Department("HR", 500, 1500);
//            Employee emp1 = new Employee("Evgeniy", "Sobolev"
//                    , 800);
//            Employee emp2 = new Employee("Andrey", "Gubanov"
//                    , 1000);
//
//            dep.addEmployeeToDepartament(emp1);
//            dep.addEmployeeToDepartament(emp2);
//
//            session.beginTransaction();
//            session.persist(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//****************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 3);
//
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//****************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//
//
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//****************

            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department = session.get(Department.class, 4);

            session.remove(department);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }


    }


}
