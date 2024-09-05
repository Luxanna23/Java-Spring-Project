package com.example.demo.mapper;

import com.example.demo.dto.DepartementDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartement().getId()
        );
    }

    public static List<EmployeeDto> maptoEmployeeListDto(List<Employee> employeeList)
    {
        List<EmployeeDto> employeeListDto = new ArrayList<>();
        for (Employee employee: employeeList
        ) {
            employeeListDto.add(maptoEmployeeDto(employee));
        }
        return employeeListDto;
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

}
