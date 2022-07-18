package com.example.demoplanning.service.permanence;

import com.example.demoplanning.domain.Permanence;
import com.example.demoplanning.repository.PermanenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PermanenceImpl implements PermanenceService{
    @Autowired
    PermanenceRepository repository;

    public void save(Permanence permanence){
        repository.save(permanence);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<Permanence> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Permanence> findById(Long id){
        return repository.findById(id);
    }

}
