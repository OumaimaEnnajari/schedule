package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;


@Data  @NoArgsConstructor
@Entity

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Long id;
    @Column(unique = true)
    private String  userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER )
    private Collection<AppRole> appRoles=new ArrayList<AppRole>();
    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @OneToOne(mappedBy = "user")
    private Prof prof;

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", appRoles=" + appRoles +
                '}';
    }
}