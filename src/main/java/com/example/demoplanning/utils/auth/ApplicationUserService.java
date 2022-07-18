package com.example.demoplanning.utils.auth;

import com.example.demoplanning.domain.User;
import com.example.demoplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userRepository.findByName(username).get();

       if(user == null){
           System.out.println("rambo");
           throw new UsernameNotFoundException("Utilisateur non trouvé");

       }


       return new ApplicationUser(user);
           }
}