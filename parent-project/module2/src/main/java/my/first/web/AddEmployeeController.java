package my.first.web;

import my.first.model.Department;
import my.first.model.Employee;
import my.first.service.DepartmentService;
import my.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/add-employee.html")
    public ModelAndView showAddEmployeePage() {
        List<Department> departments = departmentService.getAll();
        return new ModelAndView(
                "add_employee",
                Map.of("departments", departments)
        );
    }

    @PostMapping("/add-employee.html")
    public String addEmployee(Employee employee) {
        System.out.println("Call addEployee: " + employee);
        employeeService.add(employee);
        return "redirect:/employee-list.html";
    }

}
