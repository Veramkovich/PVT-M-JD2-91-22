package my.first.dao;

import my.first.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        create(employee);
    }

    @Override
    public void delete(Employee employee) {
        Employee loadedEmployee = sessionFactory.getCurrentSession().load(Employee.class, employee.getId());
        sessionFactory.getCurrentSession().delete(loadedEmployee);
    }
}
