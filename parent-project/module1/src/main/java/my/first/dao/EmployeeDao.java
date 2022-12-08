package my.first.dao;

import my.first.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee findById(long id);

    void update(Employee employee);

    void delete(Employee employee);

    List<Employee> findAll();
}
