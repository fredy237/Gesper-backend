package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.AgencyTypeRole;
import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.service.agencyTypeRole.AgencyTypeRoleImpl;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agencyTypeRole")
@CrossOrigin("http://localhost:4200")
public class AgencyTypeRoleRestController {
    @Autowired
    AgencyTypeRoleImpl service;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNumber(@RequestBody AgencyTypeRole agencyTypeRole) {
        System.out.println(agencyTypeRole);
        String  message = "creation reussie";
        agencyTypeRole.setNumber(agencyTypeRole.getNumber() +1);
        service.save(agencyTypeRole);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @PostMapping("/remove")
    public ResponseEntity<ResponseMessage> removeNumber(@RequestBody AgencyTypeRole agencyTypeRole) {
        System.out.println(agencyTypeRole);
        String  message = "creation reussie";
        agencyTypeRole.setNumber(agencyTypeRole.getNumber() -1);
        service.save(agencyTypeRole);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage> delete(@RequestBody AgencyTypeRole agencyTypeRole) {
        System.out.println(agencyTypeRole);
        String  message = "suppression  reussie";

        service.delete(agencyTypeRole.getId());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }
}
