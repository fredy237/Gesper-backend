package com.example.demoplanning.service.agencyTypeRole;

import com.example.demoplanning.domain.AgencyTypeRole;

import java.util.List;
import java.util.Optional;

public interface AgencyTypeRoleService {
    public void save(AgencyTypeRole agencyTypeRole);
    public List<AgencyTypeRole> findAll();
    public Optional<AgencyTypeRole> findById(Long id);
    public void delete(Long id);

}
