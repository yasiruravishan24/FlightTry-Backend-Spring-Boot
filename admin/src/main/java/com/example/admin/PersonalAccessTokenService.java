package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PersonalAccessTokenService {

    @Autowired
    private  PersonalAccessTokenRepository personalAccessTokenRepository;

    public boolean verifyToken(String token) {
        Optional<PersonalAccessToken> personalAccessTokens =
                Optional.ofNullable(personalAccessTokenRepository.findByToken(token));

        if(personalAccessTokens.isPresent()) {
            return true;
        }

        return false;
    }

    public void createAccessToken(int admin_id, String token) {

        PersonalAccessToken personalAccessToken = new PersonalAccessToken();
        personalAccessToken.setAdminId(admin_id);
        personalAccessToken.setToken(token);
        personalAccessTokenRepository.save(personalAccessToken);
    }

    public String generateToken() {
        String key = null;
        boolean  isExists = true;

        while (isExists) {
            key = generateRandomString();

            if (verifyToken(key) == false) {
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

    public void removeToken(String token) {
        Optional<PersonalAccessToken> personalAccessTokens =
                Optional.ofNullable(personalAccessTokenRepository.findByToken(token));

        if(personalAccessTokens.isPresent()) {
            personalAccessTokenRepository.deleteById(personalAccessTokens.get().getId());
        }

    }
}
