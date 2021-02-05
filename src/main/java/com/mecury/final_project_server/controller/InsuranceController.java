package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.Insurance;
import com.mecury.final_project_server.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @GetMapping
    public List<Insurance> getInsurances() {
        return insuranceService.getInsurances();
    }

    @PostMapping
    public boolean addInsurance(@RequestBody Insurance insurance) {
        return insuranceService.addInsurance(insurance);
    }
}
