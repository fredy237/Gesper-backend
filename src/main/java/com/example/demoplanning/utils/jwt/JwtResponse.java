package com.example.demoplanning.utils.jwt;


import com.example.demoplanning.domain.User;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer ";
    private User user;
    private Long id;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, User user, List<String> roles) {
        this.token = token;
        this.user = user;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

