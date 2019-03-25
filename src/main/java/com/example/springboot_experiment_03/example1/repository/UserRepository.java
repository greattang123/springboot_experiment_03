package com.example.springboot_experiment_03.example1.repository;

import com.example.springboot_experiment_03.example1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.id=:id")
    User selectById(@Param("id") int id);
}
