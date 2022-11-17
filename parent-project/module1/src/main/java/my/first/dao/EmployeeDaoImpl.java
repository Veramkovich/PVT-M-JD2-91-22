package my.first.dao;

import my.first.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.openSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        create(employee);
    }

    @Override
    public void delete(Employee employee) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            Employee loadedEmployee = sess.load(Employee.class, employee.getId());
            sess.delete(loadedEmployee);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
