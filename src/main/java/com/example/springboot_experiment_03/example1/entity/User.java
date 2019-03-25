package com.example.springboot_experiment_03.example1.entity;

import com.example.springboot_experiment_03.example1.relationship.UserAddress;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    @OneToMany(mappedBy = "user")
    private  List<UserAddress>userAddresses;
    @Column(columnDefinition = "TIMESTAMP NOT NULL "+
            "DEFAULT CURRENT_TIMESTAMP",
            updatable=false,
            insertable = false)
    private LocalDateTime insertTime;
    public User(String name){
        this.name=name;
    }
}
