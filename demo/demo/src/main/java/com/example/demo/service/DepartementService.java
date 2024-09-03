package com.example.demo.service;

import com.example.demo.dto.DepartementDto;

import java.util.List;

public interface DepartementService {
    DepartementDto createDepartement(DepartementDto departementDto);
    DepartementDto getDepartementById(Long depId);
    List<DepartementDto> getAllDepartements();
    DepartementDto updateDepartement(Long depId, DepartementDto departementDto);
    DepartementDto deleteDepartement(Long depId);
}