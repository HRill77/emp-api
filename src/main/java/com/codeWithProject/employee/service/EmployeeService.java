package com.codeWithProject.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.codeWithProject.employee.dto.EmployeeDto;
import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with ID " + id + " not found!" );
        }

        employeeRepository.deleteById(id);;
    }
    
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found!"));
    }

    public Employee updateEmployee(Long id, EmployeeDto empData){
        return employeeRepository.findById(id).map(employee ->{
            employee.setName(empData.getName());
            employee.setEmail(empData.getEmail());
            employee.setPhone(empData.getPhone());
            employee.setDepartment(empData.getDepartment());

           return employeeRepository.save(employee);
        }).orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found!"));
    }
    
}
