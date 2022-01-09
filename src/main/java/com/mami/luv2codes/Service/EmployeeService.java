package com.mami.luv2codes.Service;

import com.mami.luv2codes.model.Employee;
import com.sun.xml.bind.v2.model.core.EnumConstant;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();
  Employee findById(int theId);
  void save(Employee theEmployee);
  void deleteById(int theId);


}
