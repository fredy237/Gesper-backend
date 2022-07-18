package com.example.demoplanning.utils.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demoplanning.utils.security.ApplicationUserPermission.*;

@AllArgsConstructor
public enum ApplicationUserRole {
    EMPLOYEE(Sets.newConcurrentHashSet()),
    ADMIN(Sets.newHashSet(GENERATE_PLANNING, READ_PLANNING, EMPLOYEE_WRITE, EMPLOYEE_READ,REPORT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(READ_PLANNING,  EMPLOYEE_READ));

    private final Set<ApplicationUserPermission> permissions;

   /* ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }*/



    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority(("ROLE_" + this.name())));
        System.out.println(permissions);
        return permissions;
    }

}

