package my.first.service;

import my.first.dao.EmployeeDao;
import my.first.model.Employee;
import my.first.model.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public void add(Employee employee) {
        EmployeeDetail employeeDetail = employee.getEmployeeDetail();
        if (employeeDetail.getEmployee() == null) {
            employee.getEmployeeDetail().setEmployee(employee);
        }
        employeeDao.create(employee);
    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
