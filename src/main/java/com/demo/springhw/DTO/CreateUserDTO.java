package com.demo.springhw.DTO;

import com.demo.springhw.entity.Permission;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class CreateUserDTO implements Serializable {
    private Integer id;
    private String name;
    private String role;
    private Integer age;
    private Set<Permission> permissions;
}
