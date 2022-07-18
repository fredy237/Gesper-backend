package com.example.demoplanning.service.permanenceAssignment;

import com.example.demoplanning.domain.PermanenceAssignment;

import java.util.List;
import java.util.Optional;

public interface PermanenceAssignmentService {
    public void save(PermanenceAssignment permanenceAssignment);
    public List<PermanenceAssignment> findAll();
    public Optional<PermanenceAssignment> findById(Long id);
    public void delete(Long id);
    public  List<PermanenceAssignment> findByAgency_Name(String name);
}
