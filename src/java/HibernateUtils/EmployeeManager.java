
package HibernateUtils;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Mapping.Employee;
import Mapping.Role;
import Mapping.Task;

/**
 *
 * @author Devni
 */
public class EmployeeManager {

    public EmployeeManager() {
    }

    public List getEmployees(String employeeId) {

        Session session = SessionFactoryUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Employee> employeeList = null;

        try {
            Query query = session.createQuery(
                    "select from Employee where employeeid = "
                    + employeeId + " or -1 = "
                    + employeeId
            );
            employeeList = (List<Employee>) query.list();
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            tx.rollback();
        }

        return employeeList;
    }

    public void createEmployee(Employee employee) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (RuntimeException e) {

            if (tx != null && tx.isActive()) {

                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error occured while rolling back transaction");
                }
                throw e;
            }
        }
    }

    public void updateEmployee(Employee employee) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (RuntimeException e) {

            if (tx != null && tx.isActive()) {

                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error occured while rolling back transaction");
                }
                throw e;
            }
        }
    }
}
