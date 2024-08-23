package com.codeWithProject.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;

}
