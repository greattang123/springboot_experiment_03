package com.example.springboot_experiment_03.example1.service;

import com.example.springboot_experiment_03.example1.entity.Address;
import com.example.springboot_experiment_03.example1.entity.User;
import com.example.springboot_experiment_03.example1.relationship.UserAddress;
import com.example.springboot_experiment_03.example1.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserAddressService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserAddressRepository ur;
    public UserAddress addUserAddress(User user, Address address){
        UserAddress userAddress=new UserAddress(user,address);
        ur.save(userAddress);
        return  userAddress;
    }
}
