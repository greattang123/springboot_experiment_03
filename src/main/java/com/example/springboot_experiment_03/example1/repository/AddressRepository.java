package com.example.springboot_experiment_03.example1.repository;

import com.example.springboot_experiment_03.example1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("select a FROM Address a WHERE a.detail=:detail")
    List<Address> list(@Param("detail") String detail);
}
