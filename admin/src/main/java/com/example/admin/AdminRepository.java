package com.example.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, Integer> {
    String FIND_ADMIN = "SELECT * FROM admins WHERE username = ?1 AND password = ?2";

    @Query(value = FIND_ADMIN, nativeQuery=true)
    Admin login(String username, String password);
}
