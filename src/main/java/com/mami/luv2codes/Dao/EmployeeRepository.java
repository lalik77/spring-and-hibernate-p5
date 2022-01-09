package com.mami.luv2codes.Dao;

import com.mami.luv2codes.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
