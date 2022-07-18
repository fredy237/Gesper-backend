package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.Employee;
import com.example.demoplanning.domain.Permanence;
import com.example.demoplanning.domain.PermanenceAssignment;
import com.example.demoplanning.service.agency.AgencyImpl;
import com.example.demoplanning.service.employee.EmployeeImpl;
import com.example.demoplanning.service.permanence.PermanenceImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permanence")
@CrossOrigin("http://localhost:4200")
public class PermanenceRestController {
    @Autowired
    PermanenceImpl service;

    @Autowired
    AgencyImpl agencyService;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> savePermanenceList(@RequestBody List<Permanence> permanenceList) {

        String  message = "creation reussie";

        for (Permanence permanence : permanenceList){

            service.save(permanence);
        }

        List<Agency> agencies = agencyService.findAll();
        for(Agency agency : agencies){


            agencyService.save(agency);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/listall")
    public List<Permanence> listPermanence(){
        List<Permanence> permanences = service.findAll();
        System.out.println("mathurin "+ permanences );
        return permanences;
    }
}
