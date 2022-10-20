package com.example.apiuser;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ApiUserService {

    static final String MAIL_URL = "http://127.0.0.1:8083/v1/mails";

    @Autowired
    private  ApiUserRepository apiUserRepository;

    @Autowired
    private RestTemplate restTemplate;


    public List<ApiUser> getApiUsers() {
        return apiUserRepository.findAll();
    }

    public ApiUser createApiUser(ApiUser apiUser) {

        apiUser.setApikey(generateApiKey());
        apiUser.setApiUsage(0);
        apiUser.setStatus(true);

        ApiUser newUser = apiUserRepository.save(apiUser);


        if(newUser != null) {
            Mail mail = new Mail();
            String subject = "Welcome to FlightTry.";
            String body = "<h4 style='padding-bottom:none'>Your API Key</h4>" +
                    "<p>Your API key is a unique token that links your flight try account." +
                    "it grants you access to all of our services.<br/><br/>" +
                    "<b>API Key - </b>" +
                    "<span style='color: black'>"+newUser.getApikey()+"</span> </p>";


            setMailDetails(newUser.getF_name(), newUser.getEmail(), subject, body, mail);
            sendMail(mail);
        }

        return apiUserRepository.save(apiUser);
    }

    public ApiUser updateApiUserStatus(int id, ApiUser apiUser) {
        Optional<ApiUser> currentApiUser = apiUserRepository.findById(id);

        if(currentApiUser.isPresent()) {
            currentApiUser.get().setStatus(apiUser.isStatus());
            ApiUser updatedUser =  apiUserRepository.save(currentApiUser.get());

            if(updatedUser != null) {
                Mail mail = new Mail();
                String subject = "FlightTry API status.";
                String body = "<p>Your API key is " + (updatedUser.isStatus() ? "Active" : "Disable") + " now.";

                setMailDetails(updatedUser.getF_name(), updatedUser.getEmail(), subject, body, mail);
                sendMail(mail);
            }
        }




        return currentApiUser.orElse(null) ;

    }

    public ApiUser updateApiUserUsage(int id) {
        Optional<ApiUser> currentApiUser = apiUserRepository.findById(id);

        if(currentApiUser.isPresent()) {
            currentApiUser.get().setApiUsage( currentApiUser.get().getApiUsage() + 1);
            apiUserRepository.save(currentApiUser.get());
        }


        return currentApiUser.orElse(null);

    }
    public ApiUser verifyApikey(String apikey) {
        Optional<ApiUser> apiUser = Optional.ofNullable(apiUserRepository.findByApikey(apikey));

        return apiUser.orElse(null);
    }

    // generate api key
    private String generateApiKey() {
        String key = null;
        boolean  isExists = true;

        while (isExists) {
            key = generateRandomString();
            ApiUser isExistApiUser = verifyApikey(key);

            if(isExistApiUser == null) {
                isExists = false;
            }
        }

       return key;
    }

    private String generateRandomString() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 50;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private void setMailDetails( String name, String email,String subject ,String body, Mail mail) {
            mail.setName(name);
            mail.setEmail(email);
            mail.setSubject(subject);
            mail.setBody(body);
    }

    private void sendMail(Mail mail) {
        restTemplate.postForObject(MAIL_URL, mail, JSONObject.class);
    }

    public ApiUser checkEmail(String email) {

        Optional<ApiUser> apiUser = Optional.ofNullable(apiUserRepository.findByEmail(email));

        return apiUser.orElse(null);
    }

    public ApiUser checkHost(String host) {

        Optional<ApiUser> apiUser = Optional.ofNullable(apiUserRepository.findByHost(host));

        return apiUser.orElse(null);
    }
}
