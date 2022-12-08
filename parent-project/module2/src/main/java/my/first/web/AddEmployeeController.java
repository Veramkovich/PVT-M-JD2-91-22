package my.first.web;

import my.first.model.Employee;
import my.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/add-employee.html")
    public String showAddEmployeePage() {
        return "add_employee";
    }

    @PostMapping("/add-employee.html")
    public String addEmployee(Employee employee) {
        System.out.println("Call addEployee: " + employee);
        employeeService.add(employee);
        return "redirect:/employee-list.html";
    }

}
