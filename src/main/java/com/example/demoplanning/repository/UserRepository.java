package com.example.demoplanning.repository;

import com.example.demoplanning.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByName(String name);
}