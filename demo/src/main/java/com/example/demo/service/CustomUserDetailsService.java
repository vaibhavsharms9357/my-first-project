package com.example.demo.service;

import com.example.demo.modal.UserDemo1;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService (UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDemo1 userDemo1=userRepository.findByUsername(username);

        if(userDemo1==null)
            throw  new UsernameNotFoundException("user is not Found "+ username);

        return userDemo1;
    }
}
