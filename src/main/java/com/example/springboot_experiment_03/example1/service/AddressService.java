package com.example.springboot_experiment_03.example1.service;

import com.example.springboot_experiment_03.example1.entity.Address;
import com.example.springboot_experiment_03.example1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class AddressService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AddressRepository as;
    public Address addAddress(String detail){
        Address address=new Address(detail);
        as.save(address);
//        as.refresh(address);
        return address;
    }
}
