package my.first.web;

import my.first.model.Employee;
import my.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EmployeeListController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list.html")
    public ModelAndView showEmployeeList() {
        return new ModelAndView(
                "employee_list",
                Map.of("employees", employeeService.getAll())
        );
    }

    @ResponseBody
    @GetMapping("/image/{employee.id}/photo.jpg")
    public byte[] getImage(@PathVariable("employee.id") long employeeId) {
        System.out.println("Call getImage: " + employeeId);
        Employee empl = employeeService.getById(employeeId);
        return empl.getEmployeePhoto().getPhoto();
    }
}
