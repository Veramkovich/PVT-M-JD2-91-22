package my.first.dao;

import my.first.MysqlSessionFactory;
import my.first.model.Employee;
import org.hibernate.SessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl() {
        this(MysqlSessionFactory.getInstance());
    }

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.openSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}
