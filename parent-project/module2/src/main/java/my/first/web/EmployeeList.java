package my.first.web;

import my.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EmployeeList {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list.html")
    public ModelAndView showEmployeeList() {
        return new ModelAndView(
                "employee_list",
                Map.of("employees", employeeService.getAll())
        );
    }
}
