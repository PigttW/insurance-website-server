package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.Insurance;
import com.mecury.final_project_server.dao.InsuranceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranceDao insuranceDao;

    public List<Insurance> getInsurances() {
        return insuranceDao.findAll();
    }

    @Transactional
    public boolean addInsurance(Insurance insurance) {
        try {
            insuranceDao.save(insurance);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
