package com.example.demo.controller;

import com.example.demo.modal.AuthRequest;
import com.example.demo.modal.UserDemo1;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        // this hold the authentication and pass it to authentication Provider
        return "Token Generate successfully";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDemo1 user){
        user.setPassWord(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "user Generated Successfully";
    }
}
