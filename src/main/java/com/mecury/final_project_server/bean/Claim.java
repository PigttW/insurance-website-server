package com.mecury.final_project_server.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CLAIM")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "csg")
    @SequenceGenerator(name = "csg", sequenceName = "CLAIM_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "CLAIM_DATE")
    Date claimDate;
    @Column
    private double billed;
    @Column(name = "PATIENT_RESPONSIBILITY")
    private double patientResponsibility;
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    UserDetail userProfile;
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
    ProviderDetail providerDetail;

    public Claim() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public double getBilled() {
        return billed;
    }

    public void setBilled(double billed) {
        this.billed = billed;
    }

    public double getPatientResponsibility() {
        return patientResponsibility;
    }

    public void setPatientResponsibility(double patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public UserDetail getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserDetail userProfile) {
        this.userProfile = userProfile;
    }

    public ProviderDetail getProviderDetail() {
        return providerDetail;
    }

    public void setProviderDetail(ProviderDetail providerDetail) {
        this.providerDetail = providerDetail;
    }
}
