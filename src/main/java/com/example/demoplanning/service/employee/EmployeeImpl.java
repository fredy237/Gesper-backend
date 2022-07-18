package com.example.demoplanning.service.employee;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.Employee;
import com.example.demoplanning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class EmployeeImpl implements EmployeeService{
    @Autowired
    EmployeeRepository repository;

    public void save(Employee employee){
        repository.save(employee);
    }
    public  void delete(Long id){
        repository.deleteById(id);
    }




    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Optional<Employee> findByName(String name){
        return repository.findByName(name);
    }
}
