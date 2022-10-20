package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private  AdminRepository adminRepository;

    @Autowired
    private  PersonalAccessTokenService  personalAccessTokenService;


    public ResponseData login(Credentials credentials) {

        ResponseData res = new ResponseData();

        Optional<Admin> admin = Optional.ofNullable(adminRepository.login(credentials.getUsername(), credentials.getPassword()));

        if(admin.isPresent()) {

            String token = personalAccessTokenService.generateToken();
            int admin_id = admin.get().getId();

            personalAccessTokenService.createAccessToken(admin_id, token);

            res.setMessage("login success ");
            res.setStatus_code(200);
            res.setData(new ArrayList<String>(Collections.singleton(token)));

            return  res;
        }

        res.setMessage("unauthorized Access");
        res.setStatus_code(401);

        return res;
    }

    public ResponseData logout(String token) {

        ResponseData res = new ResponseData();

        if(personalAccessTokenService.verifyToken(token)) {

            personalAccessTokenService.removeToken(token);
            res.setMessage("logout success");
            res.setStatus_code(200);

            return  res;
        }

        res.setMessage("unauthorized Access");
        res.setStatus_code(401);

        return res;

    }
}
