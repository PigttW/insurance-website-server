package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.Insurance;
import com.mecury.final_project_server.dao.InsuranceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranceDao insuranceDao;

    public List<Insurance> getInsurances() {
        return insuranceDao.findAll();
    }
}
