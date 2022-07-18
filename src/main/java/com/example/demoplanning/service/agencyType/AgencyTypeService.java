package com.example.demoplanning.service.agencyType;

import com.example.demoplanning.domain.AgencyType;

import java.util.List;
import java.util.Optional;

public interface AgencyTypeService {
    public void save(AgencyType agecny);
    public List<AgencyType> findAll();
    public Optional<AgencyType> findById(Long id);
    public void delete(Long id);
    public Optional<AgencyType> findByType(String type);
}
