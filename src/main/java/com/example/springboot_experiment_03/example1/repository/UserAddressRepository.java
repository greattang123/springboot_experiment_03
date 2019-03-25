package com.example.springboot_experiment_03.example1.repository;

import com.example.springboot_experiment_03.example1.entity.User;
import com.example.springboot_experiment_03.example1.relationship.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer>{
    @Query("SELECT u FROM UserAddress u WHERE u.user.name=:name AND u.address.detail=:detail")
    UserAddress select(@Param("name") String name, @Param("detail") String detail);
}

