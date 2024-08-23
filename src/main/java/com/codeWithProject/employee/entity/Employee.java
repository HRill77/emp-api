package com.codeWithProject.employee.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;


    public Employee(String name, String email, String phone, String department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    
    
}
