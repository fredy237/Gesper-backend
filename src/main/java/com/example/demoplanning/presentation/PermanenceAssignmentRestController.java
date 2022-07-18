package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.*;
import com.example.demoplanning.service.permanenceAssignment.PermanenceAssignmentImpl;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permanenceAssignment")
@CrossOrigin("http://localhost:4200")
public class PermanenceAssignmentRestController {

    @Autowired
    PermanenceAssignmentImpl service;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> savePermanenceAssignment(@RequestBody List<PermanenceAssignment> permanenceAssignmentList) {
        String  message = "creation reussie";
        for (PermanenceAssignment permanenceAssignment : permanenceAssignmentList){
            service.save(permanenceAssignment);
        }


        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/listall")
    public List<PermanenceAssignment> listPermanence(){
        List<PermanenceAssignment> permanences = service.findAll();
        return permanences;
    }


    @GetMapping("/listByAgency")
    public List<PermanenceAssignment> listPermanenceAssignmentByAgencyName(@RequestParam String name){
        List<PermanenceAssignment> permanenceAssignments = service.findByAgency_Name(name);
        System.out.println("mathur "+permanenceAssignments);
        return permanenceAssignments;
    }
}
