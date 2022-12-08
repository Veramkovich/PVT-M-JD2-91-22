package my.first.service;

import my.first.dao.DepartmentDao;
import my.first.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public void add(Department department) {
        departmentDao.create(department);
    }

    public List<Department> getAll() {
        return departmentDao.findAll();
    }

}
