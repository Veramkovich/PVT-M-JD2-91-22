package my.first.service;

import my.first.dao.EmployeeDao;
import my.first.model.Employee;
import my.first.model.EmployeeDetail;
import my.first.model.EmployeePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public void add(Employee employee, byte[] photo) {
        EmployeeDetail employeeDetail = employee.getEmployeeDetail();
        if (employeeDetail.getEmployee() == null) {
            employee.getEmployeeDetail().setEmployee(employee);
        }

        if (employee.getEmployeePhoto() == null) {
            EmployeePhoto employeePhoto = new EmployeePhoto();
            employeePhoto.setEmployee(employee);
            employeePhoto.setPhoto(photo);
            employee.setEmployeePhoto(employeePhoto);
        }

        employeeDao.create(employee);

    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public Employee getById(long employeeId) {
        return employeeDao.findById(employeeId);
    }
}
