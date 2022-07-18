package com.example.demoplanning.repository;

import com.example.demoplanning.domain.AgencyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgencyTypeRepository extends JpaRepository<AgencyType, Long> {
    public Optional<AgencyType> findByType(String type);
}
