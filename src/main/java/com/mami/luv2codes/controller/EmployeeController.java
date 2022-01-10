package com.mami.luv2codes.controller;

import com.mami.luv2codes.Service.EmployeeService;
import com.mami.luv2codes.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/showFormForAdd")
  public String  showFormForAdd(Model model) {

    Employee employee = new Employee();

    model.addAttribute("employee",employee);

    return "employees/employee-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    //save the employee
    employeeService.save(employee);
    //use a redirect to prevent duplicate submissions
    return "redirect:/employees/all";

  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

    //get the employee from the service
    Employee employee = employeeService.findById(theId);

    //set employee as a model attribute to prepopulate the form
    model.addAttribute("employee",employee);

    //send over to our form
    return "employees/employee-form";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("employeeId") int theId) {

    //delete the employee from the service
     employeeService.deleteById(theId);



    //redirect to /employees/all
    return "redirect:/employees/all";
  }

}

