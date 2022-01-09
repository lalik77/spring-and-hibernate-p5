package com.mami.luv2codes.controller;

import com.mami.luv2codes.Service.EmployeeService;
import com.mami.luv2codes.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  //quick and direct inject employee dao
  private EmployeeService employeeService;

  @Autowired // nor required
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/all")
  public String getAllEmployees(Model model) {

    List<Employee> employees = employeeService.findAll();

    model.addAttribute("employees",employees);

    return "employees/all-employees";
  }


}

