package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DepartementServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee is not found with id" + employeeId));

        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return List<EmployeeMapper.maptoEmployeeDto(employees);
    }

    @Override
    public EmployeeDto updateEmployees(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee is not found with id" + employeeId));
        return
    }

    @Override
    public EmployeeDto deleteEmployees(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee is not found with id" + employeeId));
        return
    }
}
