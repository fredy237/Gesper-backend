package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.AgencyType;
import com.example.demoplanning.domain.AgencyTypeRole;
import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.service.agencyType.AgencyTypeImpl;
import com.example.demoplanning.service.agencyTypeRole.AgencyTypeRoleService;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/agencyType")
@CrossOrigin("http://localhost:4200")
public class AgencyTypeRestController {

    @Autowired
    AgencyTypeImpl service;

    @Autowired
    SkillImpl skillService;

    @Autowired
    AgencyTypeRoleService agencyTypeRoleService;


    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveAgencyList(@RequestBody List<AgencyType> agencyList) {

        String  message = "creation reussie";

        for (AgencyType agency : agencyList){
            service.save(agency);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @PostMapping("/deleteSkill")
    public ResponseEntity<ResponseMessage> deleteSkill(@RequestBody Skill skill, @RequestParam String type) {

        String  message = "creation reussie";
        System.out.println("skill "+ skill +" type "+ type);
            AgencyType agency = service.findByType(type).get();
            List<AgencyTypeRole> skills = new ArrayList<AgencyTypeRole>();
            skills = agency.getRequiredSkill();
            for(AgencyTypeRole agencyTypeRole : skills){
                if(agencyTypeRole.getSkill() == skill){
                    skills.remove(agencyTypeRole);
                }
            }
            agency.setRequiredSkill(skills);
            service.save(agency);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }


    @PostMapping("/saveskill")
    public ResponseEntity<ResponseMessage> saveSkill(@RequestBody AgencyType agencyType, @RequestParam String name) {

        String  message = "creation reussie";
        if(service.findByType(agencyType.getType()).isEmpty()==true){
            AgencyType agencyData = new AgencyType();
            agencyData.setType(agencyType.getType());
            System.out.println("fredy");

                List<AgencyTypeRole> skills = new ArrayList<AgencyTypeRole>();

                Skill skill = new Skill();
                skill = skillService.findByName(name).get();
                AgencyTypeRole agencyTypeRole = new AgencyTypeRole();
                agencyTypeRole.setSkill(skill);
                agencyTypeRole.setNumber(1);
                agencyTypeRoleService.save(agencyTypeRole);
                skills.add(agencyTypeRole);


                agencyData.setRequiredSkill(skills);

                System.out.println(agencyData);
                service.save(agencyData);


        }else{
            AgencyType agencyData =service.findByType(agencyType.getType()).get();
            List<AgencyTypeRole> skills = agencyData.getRequiredSkill();

            Skill skill = new Skill();
            skill = skillService.findByName(name).get();
            AgencyTypeRole agencyTypeRole = new AgencyTypeRole();
            agencyTypeRole.setSkill(skill);
            agencyTypeRole.setNumber(1);
            agencyTypeRoleService.save(agencyTypeRole);
            skills.add(agencyTypeRole);
            System.out.println("enfin "+ skills);

            agencyData.setRequiredSkill(skills);

            System.out.println(agencyData);
            service.save(agencyData);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/listall")
    public List<AgencyType> list(){
        List<AgencyType> agencies = service.findAll();

        return agencies;
    }

}
