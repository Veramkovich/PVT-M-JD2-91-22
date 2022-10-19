package my.first.dao;

import my.first.model.Employee;

public interface EmployeeDao {

    void create(Employee employee);

    Employee findById(long id);

    void update(Employee employee);

    void delete(Employee employee);

}
