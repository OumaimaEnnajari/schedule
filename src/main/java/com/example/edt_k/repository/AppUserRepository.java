package com.example.edt_k.repository;

import com.example.edt_k.entity.AppUser;
import com.example.edt_k.entity.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);

    @Query("SELECT u FROM AppUser u WHERE u.userName = :x AND u.password = :y")
    AppUser findByUsernameAndPassword(@Param("x") String username, @Param("y") String password);

}