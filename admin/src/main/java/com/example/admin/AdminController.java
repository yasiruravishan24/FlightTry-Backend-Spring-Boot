package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private  PersonalAccessTokenService  personalAccessTokenService;


//    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/v1/admins/verify")
    public boolean verify(@RequestHeader("token") String token) {
         return personalAccessTokenService.verifyToken(token);
    }

//    @CrossOrigin(origins = "http://localhost:3003")
    @PostMapping("/v1/admins/login")
    public ResponseData login(@RequestBody Credentials credentials ) {
        return adminService.login(credentials);
    }

//    @CrossOrigin(origins = "http://localhost:3003")
    @PostMapping("/v1/admins/logout")
    public ResponseData getAllAdmins(@RequestHeader("token") String token) {
        return adminService.logout(token);
    }
}
