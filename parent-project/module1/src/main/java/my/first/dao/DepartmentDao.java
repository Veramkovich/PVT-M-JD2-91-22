package my.first.dao;

import my.first.model.Department;

import java.util.List;

public interface DepartmentDao {

    void create(Department department);

    Department findById(long id);

    List<String> findAllDepartmentNames();

    void update(Department department);

    void delete(long id);

    void delete(Department department);
}
