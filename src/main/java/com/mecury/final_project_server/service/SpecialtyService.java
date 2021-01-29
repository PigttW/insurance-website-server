package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.Specialty;
import com.mecury.final_project_server.dao.SpecialtyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {

    @Autowired
    SpecialtyDao specialtyDao;

    public List<Specialty> getSpecialties() {
        return specialtyDao.findAll();
    }
}
