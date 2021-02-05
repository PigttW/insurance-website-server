package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.ProviderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDetailDao extends JpaRepository<ProviderDetail, Long> {

    ProviderDetail findByUserId(long id);
}
