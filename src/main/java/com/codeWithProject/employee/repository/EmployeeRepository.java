package com.codeWithProject.employee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.service.EmployeeService;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    
}
