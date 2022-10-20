package com.example.apiuser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "api_users")
public class ApiUser extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "email")
    private String email;

    @Column(name = "host")
    private String host;

    @Column(name = "api_key")
    private String apikey;

    @Value("${some.key:true}")
    @Column(name = "status")
    private boolean status;

    @Value("${some.key:0}")
    @Column(name = "api_usage")
    private int apiUsage;


    public ApiUser() {
    }

    public ApiUser(String f_name, String l_name, String email, String host, String apikey, boolean status, int apiUsage) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.host = host;
        this.apikey = apikey;
        this.status = status;
        this.apiUsage = apiUsage;
    }

    public ApiUser(int id, String f_name, String l_name, String email, String host, String apikey, boolean status, int apiUsage) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.host = host;
        this.apikey = apikey;
        this.status = status;
        this.apiUsage = apiUsage;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getApiUsage() {
        return apiUsage;
    }

    public void setApiUsage(int apiUsage) {
        this.apiUsage = apiUsage;
    }

}
