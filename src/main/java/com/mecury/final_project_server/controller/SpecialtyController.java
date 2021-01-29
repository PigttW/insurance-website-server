package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.Specialty;
import com.mecury.final_project_server.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @GetMapping
    public List<Specialty> getSpecialties() {
        return specialtyService.getSpecialties();
    }
}
