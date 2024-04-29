package com.example.edt_k.service;

import com.example.edt_k.entity.AppRole;
import com.example.edt_k.entity.AppUser;
import com.example.edt_k.repository.AppRoleRepository;
import com.example.edt_k.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Component
@Data @AllArgsConstructor @NoArgsConstructor
@Transactional
public class AccountServiceImp implements AccountService {
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public AppUser AddNewUser(AppUser user) {
//        String pw=user.getPassword();
//        user.setPassword(passwordEncoder.encode(pw));
//        return appUserRepository.save(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser user2=appUserRepository.save(user);
        return user2;

    }

    @Override
    public AppRole AddNewRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {
        AppRole role=appRoleRepository.findByRoleName(rolename);
        AppUser user= appUserRepository.findByUserName(username);
        if(user!=null) {
            user.getAppRoles().add(role);
            appUserRepository.save(user);
        }
    }

    @Override
    public  AppUser LoadUserByUsername(String username) {return appUserRepository.findByUserName(username); }
    @Override
    public AppUser LoadUserByUsernamePassword(String username , String password) {return appUserRepository.findByUsernameAndPassword(username, password);}
    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
