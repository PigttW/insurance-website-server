package com.mecury.final_project_server.bean;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "csg")
    @SequenceGenerator(name = "csg", sequenceName = "COMMENTS_SEQ", allocationSize = 1)
    private long id;
    @Column
    private String text;
    @Column
    private String time;
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
    private ProviderDetail providerDetail;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProviderDetail getProviderDetail() {
        return providerDetail;
    }

    public void setProviderDetail(ProviderDetail providerDetail) {
        this.providerDetail = providerDetail;
    }
}
