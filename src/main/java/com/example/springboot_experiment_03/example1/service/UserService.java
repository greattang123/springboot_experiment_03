package com.example.springboot_experiment_03.example1.service;

import com.example.springboot_experiment_03.example1.entity.User;
import com.example.springboot_experiment_03.example1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository us;
    @PersistenceContext
    private EntityManager em;
    public User addUser(User user){
        us.save(user);
//        us.refresh(user);
        return user;
    }
}
