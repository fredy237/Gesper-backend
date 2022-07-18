package com.example.demoplanning.repository;

import com.example.demoplanning.domain.PermanenceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PermanenceAssignmentRepository extends JpaRepository<PermanenceAssignment, Long> {
    public List<PermanenceAssignment> findByAgency_Name(String name);
}
