package com.example.springboot_experiment_03.example1.relationship;

import com.example.springboot_experiment_03.example1.entity.Address;
import com.example.springboot_experiment_03.example1.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Address address;
    @Column(columnDefinition = "TIMESTAMP NOT NULL "+
            "DEFAULT CURRENT_TIMESTAMP",
            updatable=false,
            insertable = false)
    private LocalDateTime insertTime;
    private String comment;
    public UserAddress(User user,Address address){
        this.user=user;
        this.address=address;
    }
}
