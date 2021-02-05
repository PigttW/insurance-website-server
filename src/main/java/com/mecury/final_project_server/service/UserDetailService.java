package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.ProviderDetail;
import com.mecury.final_project_server.bean.UserDetail;
import com.mecury.final_project_server.dao.UserDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@Service
public class UserDetailService {

    @Autowired
    UserDetailDao userDetailDao;

    public UserDetail getUserDetailById(long id) {
        return userDetailDao.findByUserId(id);
    }

    @Transactional
    public boolean updateUserDetail(long id, UserDetail userDetail) {
        if (userDetailDao.existsById(id)) {
            try {
                UserDetail existUserDetail = userDetailDao.getOne(id);
                existUserDetail.setFirstName(userDetail.getFirstName());
                existUserDetail.setLastName(userDetail.getLastName());
                existUserDetail.setPhone(userDetail.getPhone());
                existUserDetail.setEmail(userDetail.getEmail());
                existUserDetail.setAddress1(userDetail.getAddress1());
                existUserDetail.setAddress2(userDetail.getAddress2());
                existUserDetail.setCity(userDetail.getCity());
                existUserDetail.setState(userDetail.getState());
                existUserDetail.setZip(userDetail.getZip());
                existUserDetail.setMyHealthTeam(userDetail.getMyHealthTeam());
                existUserDetail.setInsurance(userDetail.getInsurance());
                userDetailDao.save(existUserDetail);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Transactional
    @Rollback(value = false)
    public boolean deleteProviderFromHealthTeam(long id, ProviderDetail providerDetail) {
        if (userDetailDao.existsById(id)) {
            try {
                UserDetail detail = userDetailDao.getOne(id);
                detail.removeDetailProviderFromMyHealthTeam(providerDetail);
                userDetailDao.saveAndFlush(detail);
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
