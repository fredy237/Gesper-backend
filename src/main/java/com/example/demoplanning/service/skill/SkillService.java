package com.example.demoplanning.service.skill;

import com.example.demoplanning.domain.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    public void save(Skill skill);
    public List<Skill> findAll();
    public Optional<Skill> findById(Long id);
    public void delete(Long id);
    public Optional<Skill> findByName(String name);
}
