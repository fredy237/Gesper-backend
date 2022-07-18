package com.example.demoplanning.service.permanence;

import com.example.demoplanning.domain.Permanence;

import java.util.List;
import java.util.Optional;

public interface PermanenceService {

    public void save(Permanence permanence);
    public List<Permanence> findAll();
    public Optional<Permanence> findById(Long id);
    public void delete(Long id);
}
