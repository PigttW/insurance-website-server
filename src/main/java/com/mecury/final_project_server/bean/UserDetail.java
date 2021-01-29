package com.mecury.final_project_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "udsg")
    @SequenceGenerator(name = "udsg", sequenceName = "USER_DETAIL_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zip;
    @ManyToOne
    @JoinColumn(name = "INSURANCE", referencedColumnName = "ID")
    Insurance insurance;
    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @JsonIgnore
    private User user;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_PROVIDER",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")}
    )
    Set<ProviderDetail> myHealthTeam;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Set<ProviderDetail> getMyHealthTeam() {
        return myHealthTeam;
    }

    public void setMyHealthTeam(Set<ProviderDetail> myHealthTeam) {
        this.myHealthTeam = myHealthTeam;
    }

    public UserDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
