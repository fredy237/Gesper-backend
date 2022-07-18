package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.Permanence;
import com.example.demoplanning.domain.Skill;
import com.example.demoplanning.service.permanence.PermanenceImpl;
import com.example.demoplanning.service.skill.SkillImpl;
import com.example.demoplanning.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/skill")
@CrossOrigin("http://localhost:4200")
public class SkillRestController {

    @Autowired
    SkillImpl service;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveSkill(@RequestBody Skill skill) {
        System.out.println(skill);
        String  message = "creation reussie";

            service.save(skill);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage> deleteSkill(@RequestBody Skill skill) {
        System.out.println(skill);
        String  message = "suppression  reussie";

        service.delete(skill.getId());

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/listAll")
    public List<Skill> listSkill(){
        List<Skill> skills = service.findAll();

        return skills;
    }


}
