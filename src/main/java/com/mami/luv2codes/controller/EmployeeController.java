package com.mami.luv2codes.controller;

import com.mami.luv2codes.model.Employee;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employees")
public class EmployeeController {

  private List<Employee> employees;

  @PostConstruct
  private void loadData() {
    Employee empl1 = new Employee(1, "Leslie", "Andrews", "adf@dfg.com");
    Employee empl2 = new Employee(2, "Amanda", "Johns", "amanda@cv.com");
    Employee empl3 = new Employee(3, "Eric", "Bolton", "bolton_e@drrrfg.com");

    employees = Arrays.asList(empl1, empl2, empl3);
  }

  @GetMapping("/all")
  public String getAllEmployees(Model model) {

    model.addAttribute("employees", employees);

    return "all-employees";
  }
}
