package com.example.springboot_experiment_03;

import com.example.springboot_experiment_03.example1.entity.Address;
import com.example.springboot_experiment_03.example1.entity.User;
import com.example.springboot_experiment_03.example1.relationship.UserAddress;
import com.example.springboot_experiment_03.example1.service.AddressService;
import com.example.springboot_experiment_03.example1.service.UserAddressService;
import com.example.springboot_experiment_03.example1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserService us;
    @Autowired
    private AddressService as;
    @Autowired
    private UserAddressService uas;
    @Test
    public void addUserTest(){
        User user1=us.addUser(new User("Tom"));
        log.debug("{}", user1.getName());
        User user2=us.addUser(new User("Jack"));
        log.debug("{}", user2.getName());
    }
    @Test
    public void addAddressTest(){
        Address address1=as.addAddress("101");
        log.debug("{}", address1.getDetail());
        Address address2=as.addAddress("201");
        log.debug("{}", address2.getDetail());
        Address address3=as.addAddress("301");
        log.debug("{}", address3.getDetail());
    }
    @Test
    public  void addUserAddress(){
        UserAddress userAddress1=uas.addUserAddress(em.find(User.class, 1), em.find(Address.class, 1));
        UserAddress userAddress2=uas.addUserAddress(em.find(User.class, 1), em.find(Address.class, 2));
        UserAddress userAddress3=uas.addUserAddress(em.find(User.class, 2), em.find(Address.class, 3));
    }
}
