package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity

public class UserDemo1 implements UserDetails {
    @Id
    private int userId;
    private String username;
    private String password;
    //private String Roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public void setUserName(String username) {
        this.username = username;
    }



    public void setPassWord(String password) {
        this.password = password;
    }

//    public String getRoles() {
//        return Roles;
//    }

//    public void setRoles(String roles) {
//        Roles = roles;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
