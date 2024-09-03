package com.example.demo.service.impl;

import com.example.demo.dto.DepartementDto;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Employee;
import com.example.demo.exception.CannotDeleteException;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.mapper.DepartementMapper;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private final EmployeeRepository employeeRepository;
    private DepartementRepository departementRepository;

    @Override
    public DepartementDto createDepartement(DepartementDto departementDto){
        Departement dep = DepartementMapper.maptoDepartement(departementDto);
        Departement savedDepartement = departementRepository.save(dep);
        return DepartementMapper.maptoDepartementDto(savedDepartement);
    }

    @Override
    public DepartementDto getDepartementById(Long depId)
    {
        Departement dep = departementRepository.findById(depId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Departement is not found with id" + depId));

        return DepartementMapper.maptoDepartementDto(dep);
    }
    @Override
    public List<DepartementDto> getAllDepartements()
    {
        List<Departement> departementList = departementRepository.findAll();
        return DepartementMapper.maptoDepartementListDto(departementList);
    }

    @Override
    public DepartementDto updateDepartement(Long depId, DepartementDto departementDto) {
        Departement dep = departementRepository.findById(depId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Employee not found with id: " + depId));

        dep.setName(departementDto.getName());
        dep.setDescription(departementDto.getDescription());

        Departement updatedDepartement = departementRepository.save(dep);
        return DepartementMapper.maptoDepartementDto(updatedDepartement);
    }

    @Override
    public DepartementDto deleteDepartement(Long depId) {
        Departement dep = departementRepository.findById(depId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("Departement not found with id: " + depId));

        List<Employee> employees = employeeRepository.getEmployeesByDepartement(depId);

        if (!employees.isEmpty()) {
            throw new CannotDeleteException("Cannot delete department with id " + depId);
        }
        departementRepository.delete(dep);
        return null;
    }
}
