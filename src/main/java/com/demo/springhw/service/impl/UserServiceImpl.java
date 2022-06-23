package com.demo.springhw.service.impl;

import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.User;
import com.demo.springhw.repository.UserRepository;
import com.demo.springhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(CreateUserDTO request) {
        User user = new User(request.getName(), request.getRole(), request.getAge());
        userRepository.save(user);
    }

    @Override
    public List<User> getListUserWithFilter(String actionName) {
        //todo :check actioname of permission > return list ?
        return null;
    }
}
