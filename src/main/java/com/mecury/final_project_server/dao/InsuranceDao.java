package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceDao extends JpaRepository<Insurance, Long> {
}
