package com.demo.springhw.service;

import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.User;

import java.util.List;

public interface UserService {
    List<User> getListUser ();
    void createUser(CreateUserDTO request);
    List<User> getListUserWithFilter(String actionName);
}
