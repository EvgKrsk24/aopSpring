package hebernate_one_to_many_bi;


import hebernate_one_to_many_bi.entity.Department;

import hebernate_one_to_many_bi.entity.Employee;
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
//            Department dep = new Department("Sales"
//                    ,800, 1500);
//            Employee emp1 = new Employee("Evgeniyy", "SoLovev"
//                    , 800);
//            Employee emp2 = new Employee("Elena", "Smirnova"
//                    , 1500);
//            Employee emp3 = new Employee("Anton", "Pupkin"
//                    , 1200);
//
//
//            dep.addEmployeeToDepartament(emp1);
//            dep.addEmployeeToDepartament(emp2);
//            dep.addEmployeeToDepartament(emp3);
//
//
//            session.beginTransaction();
//            session.persist(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//****************

            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department = session.get(Department.class, 20);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0); //получаем лубой объект из списка тем самым подгружаем(делаем селет) полный список работников

            session.getTransaction().commit();

            System.out.println("Show emplotees of the department");
            System.out.println(department.getEmps());

            System.out.println("Done!");
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

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 5);
//
//            session.remove(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



        }
        finally {
            session.close();
            factory.close();
        }


    }


}
