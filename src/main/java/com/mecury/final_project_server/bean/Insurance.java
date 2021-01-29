package com.mecury.final_project_server.bean;

import org.hibernate.service.spi.InjectService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE")
public class Insurance {

    @Id
    private long id;
    @Column
    private String type;
    @Column(name = "OUT_OF_POCKET_MAXIMUM")
    private double outOfPocketMaximum;
    @Column
    private double deductible;
    @Column
    private double monthlyRate;

    public Insurance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOutOfPocketMaximum() {
        return outOfPocketMaximum;
    }

    public void setOutOfPocketMaximum(double outOfPocketMaximum) {
        this.outOfPocketMaximum = outOfPocketMaximum;
    }

    public double getDeductible() {
        return deductible;
    }

    public void setDeductible(double deductible) {
        this.deductible = deductible;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }
}
