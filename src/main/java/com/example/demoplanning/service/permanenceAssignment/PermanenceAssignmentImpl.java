package com.example.demoplanning.service.permanenceAssignment;

import com.example.demoplanning.domain.PermanenceAssignment;
import com.example.demoplanning.repository.PermanenceAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermanenceAssignmentImpl implements PermanenceAssignmentService{
    @Autowired
    PermanenceAssignmentRepository repository;

    public void save(PermanenceAssignment permanenceAssignment){
        repository.save(permanenceAssignment);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<PermanenceAssignment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PermanenceAssignment> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public List<PermanenceAssignment> findByAgency_Name(String name) {
        return repository.findByAgency_Name(name);
    }
}
