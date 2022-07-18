package com.example.demoplanning.service.agencyType;

import com.example.demoplanning.domain.AgencyType;
import com.example.demoplanning.repository.AgencyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyTypeImpl implements AgencyTypeService {

    @Autowired
    AgencyTypeRepository repository;

    public void save(AgencyType agency){
        repository.save(agency);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<AgencyType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AgencyType> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Optional<AgencyType> findByType(String type){
        return repository.findByType(type);
    }




}
