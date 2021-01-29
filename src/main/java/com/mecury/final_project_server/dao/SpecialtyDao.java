package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyDao extends JpaRepository<Specialty, Long> {
}
