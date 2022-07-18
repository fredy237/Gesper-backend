package com.example.demoplanning.repository;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.AgencyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgencyRepositery extends JpaRepository<Agency, Long> {
    public Optional<Agency> findByName(String name);
}
