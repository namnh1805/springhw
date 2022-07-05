package com.demo.springhw.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tblDocument")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameDocument;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
