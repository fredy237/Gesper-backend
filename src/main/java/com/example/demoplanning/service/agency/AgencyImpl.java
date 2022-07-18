package com.example.demoplanning.service.agency;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.AgencyType;
import com.example.demoplanning.repository.AgencyRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgencyImpl implements AgencyService {
    @Autowired
    AgencyRepositery repository;

    public void save(Agency agency){
        repository.save(agency);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<Agency> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Agency> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Optional<Agency> findByName(String name){
        return repository.findByName(name);
    }
}
