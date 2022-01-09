package com.mami.luv2codes.Service;

import com.mami.luv2codes.Dao.EmployeeRepository;
import com.mami.luv2codes.model.Employee;
import java.util.List;
import java.util.Optional;
import org.hibernate.engine.transaction.jta.platform.internal.StandardJtaPlatformResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired //not required
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int theId) {

    Optional<Employee> result = employeeRepository.findById(theId);
    Employee theEmployee = null;
    if (result.isPresent()) {
      theEmployee = result.get();
    } else {
      throw new RuntimeException("Did not find employee id - " + theId);
    }
    return theEmployee;
  }

  @Override
  public void save(Employee theEmployee) {
    employeeRepository.save(theEmployee);
  }

  @Override
  public void deleteById(int theId) {
    employeeRepository.deleteById(theId);
  }
}