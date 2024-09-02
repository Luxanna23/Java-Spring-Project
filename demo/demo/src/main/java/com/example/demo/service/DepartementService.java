package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;

public interface DepartementService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    EmployeeDto getAllEmployees();
    EmployeeDto updateEmployees(Long employeeId);
    EmployeeDto deleteEmployees(Long employeeId);
}