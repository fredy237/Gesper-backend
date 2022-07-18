package com.example.demoplanning.repository;

import com.example.demoplanning.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    public Optional<Skill> findByName(String name);
}
