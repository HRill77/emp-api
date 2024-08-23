package com.codeWithProject.employee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithProject.employee.dto.EmployeeDto;
import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.payload.message.ErrorResponse;
import com.codeWithProject.employee.repository.EmployeeRepository;
import com.codeWithProject.employee.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<?> postEmployee(@RequestBody EmployeeDto empDto) {
        //TODO: process POST request
       try{

        if (empDto.getName() == null || empDto.getName().isEmpty() ||
        empDto.getEmail() == null || empDto.getEmail().isEmpty() ||
        empDto.getPhone() == null || empDto.getPhone().isEmpty() ||
        empDto.getDepartment() == null || empDto.getDepartment().isEmpty()
        ) {
            ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_ACCEPTABLE.value(),
                "Not Acceptible",
                "/api/employee/post");
            return ResponseEntity.badRequest().body(errorResponse);
        }




        Employee employee = new Employee(empDto.getName(),
        empDto.getEmail(),
        empDto.getPhone(),
        empDto.getDepartment());
        employeeService.postEmployee(employee);
        return ResponseEntity.ok("New employee is added successfuly!");
       } catch (Exception e){
        return ResponseEntity.badRequest().build();
       }
    }
    


    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeebyid(@PathVariable Long id){
        try{
            employeeService.deleteEmployee(id);

            return new ResponseEntity<>("Employee with ID " + id + " deleted successfully", HttpStatus.OK);
        }catch(EntityNotFoundException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/{id}")   
    EmployeeDto getEmplyeeByid(@PathVariable Long id){
        Employee employee = employeeService.findEmployeeById(id);
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setDepartment(employee.getDepartment());

        return dto;
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto empDto) {
        //TODO: process PUT request
        try {
            employeeService.updateEmployee(id, empDto);
            return new ResponseEntity<>("Employee with ID " + id + " updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
