package com.example.demoplanning.domain;

import com.example.demoplanning.utils.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.example.demoplanning.utils.security.ApplicationUserRole.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String roleAccess;

    public ApplicationUserRole getAccess(String role){
        if(role.equals("admin")){
            return ADMIN;
        }else if(role.equals("AdminTrainee") ){
            return ADMINTRAINEE;
        }else {;
            return EMPLOYEE;
        }
    }

    public String getRoleAccess() {
        return roleAccess;
    }
}
