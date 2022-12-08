package my.first.service;

import my.first.dao.EmployeeDao;
import my.first.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public void add(Employee employee) {
        /*if(employee.getEmployeeDetail().getEmployee() == null) {
            employee.getEmployeeDetail().setEmployee(employee);
        }*/
        employeeDao.create(employee);
    }
}
