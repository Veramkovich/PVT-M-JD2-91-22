package my.first.web;

import my.first.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DepartmentListController {

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/department-list.html")
    public ModelAndView showDepartmentList() {
        return new ModelAndView(
                "department_list",
                Map.of("departments", departmentDao.findAllDepartmentNames())
        );
    }

}
