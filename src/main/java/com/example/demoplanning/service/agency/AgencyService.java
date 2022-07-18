package com.example.demoplanning.service.agency;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.AgencyType;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    public void save(Agency agecny);
    public List<Agency> findAll();
    public Optional<Agency> findById(Long id);
    public void delete(Long id);
    public Optional<Agency> findByName(String name);
}
