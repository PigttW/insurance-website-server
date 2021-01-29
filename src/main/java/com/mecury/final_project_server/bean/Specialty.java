package com.mecury.final_project_server.bean;

import javax.persistence.*;

@Entity
@Table(name = "SPECIALTY")
public class Specialty {

    @Id
    private long id;
    @Column
    private String type;

    public Specialty() {
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
}
