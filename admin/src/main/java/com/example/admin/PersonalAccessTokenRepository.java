package com.example.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalAccessTokenRepository  extends JpaRepository<PersonalAccessToken, Integer> {

    String FIND_TOKEN = "SELECT * FROM personal_access_tokens WHERE token = ?1";
    @Query(value = FIND_TOKEN, nativeQuery=true)
    PersonalAccessToken findByToken(String token);

}
