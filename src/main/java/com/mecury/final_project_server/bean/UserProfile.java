package com.mecury.final_project_server.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "upsg")
    @SequenceGenerator(name = "upsg", sequenceName = "USER_PROFILE_SEQ", allocationSize = 1)
    private long id;
    @Column
    private String type;

    public UserProfile() {
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

    @Override
    public String getAuthority() {
        return type;
    }
}
