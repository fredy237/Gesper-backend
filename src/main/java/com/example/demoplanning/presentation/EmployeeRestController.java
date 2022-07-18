package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.Employee;
import com.example.demoplanning.service.agency.AgencyImpl;
import com.example.demoplanning.service.employee.EmployeeImpl;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeRestController {
    @Autowired
    EmployeeImpl service;

    @Autowired
    SkillImpl skillService;

    @Autowired
    AgencyImpl agencyService ;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveEmployeeList(@RequestBody List<Employee> employeeList) {

        String  message = "creation reussie";

        for (Employee employee : employeeList){
           employee.setSkill(skillService.findByName(employee.getSkill().getName()).get());
          Agency agency= agencyService.findByName(employee.getAgency()).get();
          List<Employee> employees = agency.getEmployees();
          employees.add(employee);

          agency.setEmployees(employees);
            System.out.println("azer"+agency.getEmployees());
            service.save(employee);
            agencyService.save(agency);

        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

}
