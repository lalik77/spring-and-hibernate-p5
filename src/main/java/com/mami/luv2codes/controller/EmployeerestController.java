package com.mami.luv2codes.controller;

import com.mami.luv2codes.Service.EmployeeService;
import com.mami.luv2codes.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeerestController {

  //quick and direct inject employee dao
  private EmployeeService employeeService;

  @Autowired // nor required
  public EmployeerestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  //expose "/employees" and return lis of employees
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployee(@PathVariable("id") int id) {

    Employee employee = employeeService.findById(id);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + id);
    }
    return employee;
  }
  @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee employee) {

      // also just in case they pass an id in JSON .. set id to
      employee.setId(0);
      // this is to force a save of new item ... instead of update
      employeeService.save(employee);
      return employee;
  }

  @PutMapping("/employees/")
  public Employee updateEmployee(@RequestBody Employee employee) {
    // this is to force a save of new item ... instead of update

    employeeService.save(employee);
    return employee;
  }


  @DeleteMapping("/employees/{id}")
  public String deleteEmployeeById( @PathVariable int id) {
    // this is to force a save of new item ... instead of update

    Employee temp = employeeService.findById(id);

    if (temp == null) {
      throw new RuntimeException("Employee with " + id + " does not exist in DB");
    }

    employeeService.deleteById(id);
    return "Deleted Employee with id : " + id + " from DB";
  }
}

