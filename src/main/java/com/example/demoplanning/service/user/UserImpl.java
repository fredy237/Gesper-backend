package com.example.demoplanning.service.user;

import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.domain.User;
import com.example.demoplanning.repository.SkillRepository;
import com.example.demoplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository repository;

    public void save(User user){
        repository.save(user);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByName(String name){
        return repository.findByName(name);
    }
}
