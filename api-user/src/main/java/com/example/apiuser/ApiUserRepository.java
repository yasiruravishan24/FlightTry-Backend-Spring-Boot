package com.example.apiuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends JpaRepository <ApiUser, Integer>  {

    String FIND_APIKEY = "SELECT * FROM api_users WHERE api_key = ?1";
    String CHECK_EMAIL = "SELECT * FROM api_users WHERE email = ?1";

    String CHECK_HOST = "SELECT * FROM api_users WHERE host = ?1";

    @Query(value = FIND_APIKEY, nativeQuery=true)
    ApiUser findByApikey(String apikey);

    @Query(value = CHECK_EMAIL, nativeQuery=true)
    ApiUser findByEmail(String email);

    @Query(value = CHECK_HOST, nativeQuery=true)
    ApiUser findByHost(String host);
}
