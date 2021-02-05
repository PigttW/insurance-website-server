package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.ProviderDetail;
import com.mecury.final_project_server.dao.ProviderDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProviderDetailService {

    @Autowired
    ProviderDetailDao providerDetailDao;

    public ProviderDetail getProviderDetailById(long id) {
        return providerDetailDao.findByUserId(id);
    }

    public List<ProviderDetail> getProviderDetails() {
        return providerDetailDao.findAll();
    }

    @Transactional
    public boolean updateProviderDetail(long id, ProviderDetail providerDetail) {
        if (providerDetailDao.existsById(id)) {
            try {
                ProviderDetail existProviderDetail = providerDetailDao.getOne(id);
                existProviderDetail.setFirstName(providerDetail.getFirstName());
                existProviderDetail.setLastName(providerDetail.getLastName());
                existProviderDetail.setPhone(providerDetail.getPhone());
                existProviderDetail.setEmail(providerDetail.getEmail());
                existProviderDetail.setAddress1(providerDetail.getAddress1());
                existProviderDetail.setAddress2(providerDetail.getAddress2());
                existProviderDetail.setCity(providerDetail.getCity());
                existProviderDetail.setState(providerDetail.getState());
                existProviderDetail.setZip(providerDetail.getZip());
                existProviderDetail.setSpecialty(providerDetail.getSpecialty());
                existProviderDetail.setVerified(providerDetail.getVerified());
                providerDetailDao.save(existProviderDetail);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
