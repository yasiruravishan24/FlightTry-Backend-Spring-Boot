package com.example.apiuser;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiUserController {

    private final ApiUserService apiUserService;

    @Autowired
    public ApiUserController(ApiUserService apiUserService) {
        this.apiUserService = apiUserService;
    }

    //get all api users
    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping(path = "/v1/api-users")
    public List<ApiUser> getAllApiUsers() {
        return  apiUserService.getApiUsers();
    }

    //register api user
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/v1/api-users")
    public ApiUser registerApiUser(@RequestBody ApiUser apiuser) {return  apiUserService.createApiUser(apiuser);
    }

    //get verify api key
    @GetMapping(path = "/v1/api-users/verify-key")
    public ApiUser verifyApiUser(@RequestParam String apikey) {
        return  apiUserService.verifyApikey(apikey);
    }

    //update user status
    @CrossOrigin(origins = "http://localhost:3003")
    @PutMapping(path = "/v1/api-users/status/{id}")
    public ApiUser verifyApiUserStatus(@PathVariable int id, @RequestBody ApiUser apiUser) {
        return  apiUserService.updateApiUserStatus(id, apiUser);
    }

    //update user usages
    @PutMapping(path = "/v1/api-users/usage/{id}")
    public ApiUser verifyApiUserUsage(@PathVariable int id) {
        return  apiUserService.updateApiUserUsage(id);
    }

    //check email already exist
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/v1/api-users/email")
    public ApiUser checkEmail(@RequestParam String email) {
        return apiUserService.checkEmail(email);
    }

    //check host already exist
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/v1/api-users/host")
    public ApiUser checkHost(@RequestParam String host) {
        return apiUserService.checkHost(host);
    }

}
