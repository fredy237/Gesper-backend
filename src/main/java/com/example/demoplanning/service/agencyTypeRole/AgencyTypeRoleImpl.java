package com.example.demoplanning.service.agencyTypeRole;


import com.example.demoplanning.domain.AgencyTypeRole;
import com.example.demoplanning.repository.AgencyTypeRoleRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyTypeRoleImpl implements AgencyTypeRoleService{

    @Autowired
    AgencyTypeRoleRepositery repository;

    public void save(AgencyTypeRole agency){
        repository.save(agency);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<AgencyTypeRole> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AgencyTypeRole> findById(Long id){
        return repository.findById(id);
    }

}
