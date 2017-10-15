package HibernateUtils;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Mapping.Role;

/**
 *
 * @author Shavindra
 */
public class RoleManager {

    public RoleManager() {
    }

    public void createRole(Role role) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.save(role);
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

    public void updateRole(Role role) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.update(role);
            tx.commit();
        } catch (RuntimeException e) {

            if (tx != null && tx.isActive()) {

                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error occured while rolling back transaction");
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    public List getRoles(String roleId) {

        Session session = SessionFactoryUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Role> roleList = null;

        try {
            Query query = session.createQuery(
                    "select from Role where roleid = "
                    + roleId
                    + " or -1 = " + roleId);
            roleList = (List<Role>) query.list();
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            tx.rollback();
        }

        return roleList;
    }

    public List getAvailableRoles() {

        Session session = SessionFactoryUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Role> roleList = null;

        try {
            Query query = session.createQuery(
                    "SELECT FROM Role AS r WHERE NOT EXISTS"
                    + "(SELECT e.role FROM Employee AS e WHERE e.role = r.roleid)");

            roleList = (List<Role>) query.list();
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            tx.rollback();
        }

        return roleList;
    }
}
