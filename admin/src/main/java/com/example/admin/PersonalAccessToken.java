package com.example.admin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personal_access_tokens")
public class PersonalAccessToken  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "admin_id")
    private int adminId;

    @Column(name = "token")
    private String token;

    public PersonalAccessToken() {
    }

    public PersonalAccessToken(int adminId, String token) {
        this.adminId = adminId;
        this.token = token;
    }

    public PersonalAccessToken(int id, int adminId, String token) {
        this.id = id;
        this.adminId = adminId;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
