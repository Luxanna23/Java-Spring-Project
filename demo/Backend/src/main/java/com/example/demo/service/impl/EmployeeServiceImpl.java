package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Employee;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private DepartementRepository departementRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);

        Departement departement = departementRepository.findById(Long.valueOf(employeeDto.getDepartementId()))
                .orElseThrow(() ->
                        new RessourceNotFoundException("Department is not exists with id: " + employeeDto.getDepartementId()));

        employee.setDepartement(departement);

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
        List<Employee> employeeList = employeeRepository.findAll();
        return EmployeeMapper.maptoEmployeeListDto(employeeList);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee not found with id: " + employeeId));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Departement departement = departementRepository.findById(employeeDto.getDepartementId())
                .orElseThrow(() ->
                        new RessourceNotFoundException("Departement not found."));

        employee.setDepartement(departement);

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.delete(employee);
        return null;
    }
}
