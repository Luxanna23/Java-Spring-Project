package com.example.demo.controller;


import com.example.demo.dto.DepartementDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/Departements")
public class DepartementController {

    private DepartementService departementService;

    @PostMapping
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody DepartementDto departementDto)
    {
        DepartementDto savedDepartement = departementService.createDepartement(departementDto);
        return new ResponseEntity<>(savedDepartement, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable("id") Long DepartementId)
    {
        DepartementDto DepartementDto = departementService.getDepartementById(DepartementId);
        return ResponseEntity.ok(DepartementDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartementDto>> getAllDepartements()
    {
        List<DepartementDto> departementList = departementService.getAllDepartements();
        return ResponseEntity.ok(departementList);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable("id") Long depId,
                                                              @RequestBody DepartementDto departementDto)
    {
        DepartementDto updatedDepartement = departementService.updateDepartement(depId,departementDto);
        return ResponseEntity.ok(updatedDepartement);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DepartementDto> deleteDepartement(@PathVariable("id")Long depId)
    {
        DepartementDto departementDto = departementService.deleteDepartement(depId);
        return ResponseEntity.ok(departementDto);
    }
}
