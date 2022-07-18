package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.User;
import com.example.demoplanning.service.user.UserImpl;
import com.example.demoplanning.utils.auth.ApplicationUser;
import com.example.demoplanning.utils.jwt.JwtResponse;
import com.example.demoplanning.utils.jwt.JwtUtils;
import com.example.demoplanning.utils.jwt.UsernameAndPasswordAuthentificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:4200")
public class UserRestController {
    @Autowired
    UserImpl userImpl;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;



    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody UsernameAndPasswordAuthentificationRequest loginRequest) {
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        ApplicationUser applicationUser = (ApplicationUser) authentication.getPrincipal();
        List<String> roles = applicationUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        User user= userImpl.findByName(applicationUser.getUsername()).get();
        System.out.println(roles);
        return ResponseEntity.ok(new JwtResponse(jwt, user, roles));
    }

}
