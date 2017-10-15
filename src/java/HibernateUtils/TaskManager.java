package HibernateUtils;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Mapping.Task;

/**
 *
 * @author Shavindra
 */
public class TaskManager {

    public TaskManager() {
    }

    public List getTasks(String taskId) {
        Session session = SessionFactoryUtil.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Task> taskList = null;

        try {
            Query query = session.createQuery("select max(taskid) from Task where taskid = " + taskId + " or -1 = " + taskId);
            taskList = (List<Task>) query.list();
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
            tx.rollback();
        }

        return taskList;
    }

    public void createTask(Task task) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.save(task);
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

    public void updateTask(Task task) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            session.update(task);
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
