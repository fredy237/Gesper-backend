package com.example.demoplanning.service.user;

import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void save(User user);
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public void delete(Long id);
    public Optional<User> findByName(String name);
}
