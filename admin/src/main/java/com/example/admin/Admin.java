package com.example.admin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admins")
public class Admin  extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private  String username;

    @Column(name = "password")
    private String password;

    public Admin() {
    }

    public Admin(String f_name, String l_name, String email, String username, String password) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Admin(int id, String f_name, String l_name, String email, String username, String password) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
