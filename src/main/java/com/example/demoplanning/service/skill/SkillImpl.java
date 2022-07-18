package com.example.demoplanning.service.skill;

import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillImpl implements SkillService{
    @Autowired
    SkillRepository repository;

    public void save(Skill skill){
        repository.save(skill);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<Skill> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Skill> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Optional<Skill> findByName(String name){
        return repository.findByName(name);
    }
}
