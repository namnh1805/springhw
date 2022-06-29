package com.demo.springhw.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tblPermission")
public class Permission{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String action;

    @ManyToMany(mappedBy = "permissions",cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    List<User> users = new ArrayList<>();

    public Permission(String action) {
        this.action = action;
    }

}
