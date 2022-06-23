package com.demo.springhw.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tblUser")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String role;
    private int age;
    @ManyToMany
    @JoinTable(
            name = "tblAuthorization")
    @JsonIgnore
    Set<Permission> permissions;

    public User(String name, String role, int age) {
        this.name = name;
        this.role = role;
        this.age = age;
    }

}
