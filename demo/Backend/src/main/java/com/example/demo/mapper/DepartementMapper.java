package com.example.demo.mapper;

import com.example.demo.dto.DepartementDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartementMapper {
    public static DepartementDto maptoDepartementDto(Departement departement){
        return new DepartementDto(
                departement.getId(),
                departement.getName(),
                departement.getDescription()
        );
    }

    public static List<DepartementDto> maptoDepartementListDto(List<Departement> departementList)
    {
        List<DepartementDto> departementListDto = new ArrayList<>();
        for (Departement departement: departementList
        ) {
            departementListDto.add(maptoDepartementDto(departement));
        }
        return departementListDto;
    }

    public static Departement maptoDepartement(DepartementDto departementDto){
        Departement departement = new Departement();
        departement.setId(departementDto.getId());
        departement.setName(departementDto.getName());
        departement.setDescription(departementDto.getDescription());
        return departement;
    }

}
