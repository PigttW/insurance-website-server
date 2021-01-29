package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.ProviderDetail;
import com.mecury.final_project_server.service.ProviderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider-detail")
public class ProviderDetailController {

    @Autowired
    ProviderDetailService providerDetailService;

    @GetMapping
    public List<ProviderDetail> getProviderDetails() {
        return providerDetailService.getProviderDetails();
    }

    @GetMapping("/all")
    public List<ProviderDetail> getAllProviderDetails() {
        return providerDetailService.getProviderDetails();
    }


    @GetMapping("/{id}")
    public ProviderDetail getProviderDetailById(@PathVariable(name = "id") long id) {
        return providerDetailService.getProviderDetailById(id);
    }

    @PutMapping("/{id}")
    public boolean updateProviderDetail(@PathVariable(name = "id") long id, @RequestBody ProviderDetail providerDetail) {
        return providerDetailService.updateProviderDetail(id, providerDetail);
    }
}
