package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.Agency;
import com.example.demoplanning.domain.AgencyType;
import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.service.agency.AgencyImpl;
import com.example.demoplanning.service.agencyType.AgencyTypeImpl;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import com.example.demoplanning.utils.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/agency")
@CrossOrigin("http://localhost:4200")
public class AgencyRestController {


    @Autowired
    AgencyImpl service;

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    AgencyTypeImpl agencyTypeService;


    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveAgencyList(@RequestBody List<Agency> agencyList) {

        String  message = "creation reussie";

        for (Agency agency : agencyList){
            System.out.println(agency);
            agency.setAgencyType(agencyTypeService.findByType(agency.getAgencyType().getType()).get());

            service.save(agency);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }






    @GetMapping("/listall")
    public List<Agency> listAgency(){
        List<Agency> agencies = service.findAll();
        
        return agencies;
    }

}
