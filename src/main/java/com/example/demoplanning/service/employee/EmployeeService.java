package com.example.demoplanning.service.employee;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public void save(Employee employee);
    public List<Employee> findAll();
    public Optional<Employee> findById(Long id);
    public void delete(Long id);
    public Optional<Employee> findByName(String name);
}
