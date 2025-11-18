package com.example.demo.repository;

import com.example.demo.modal.UserDemo1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDemo1,Integer> {
    UserDemo1 findByUsername(String username);

}
