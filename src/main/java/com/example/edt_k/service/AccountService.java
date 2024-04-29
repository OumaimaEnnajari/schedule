package com.example.edt_k.service;

import com.example.edt_k.entity.AppRole;
import com.example.edt_k.entity.AppUser;

import java.util.List;

public interface AccountService {
    AppUser AddNewUser(AppUser user);
    AppRole AddNewRole(AppRole role);
    void AddRoleToUser(String rolename,String username);
    AppUser LoadUserByUsernamePassword(String username , String password);
    List<AppUser> listUsers();
    public  AppUser LoadUserByUsername(String username);
}