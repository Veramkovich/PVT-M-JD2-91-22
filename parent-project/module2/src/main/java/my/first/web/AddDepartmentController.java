package my.first.web;

import my.first.model.Department;
import my.first.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add-department.html")
    public String showAddDepartmentPage() {
        return "add_department";
    }

    @PostMapping("/add-department.html")
    public String addDepartment(Department department) {
        System.out.println("addDepartment: " + department);
        departmentService.add(department);
        return "redirect:/department-list.html";
    }

}
