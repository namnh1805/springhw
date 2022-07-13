package com.demo.springhw.service.impl;

import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.Permission;
import com.demo.springhw.entity.User;
import com.demo.springhw.repository.PermissionRepository;
import com.demo.springhw.repository.UserRepository;
import com.demo.springhw.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permissionRepository;


    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getPageUser(int page, int size) {
        Page<User> pageUser = userRepository.findAll(PageRequest.of(page, size));
        return pageUser;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void createUser(CreateUserDTO request) {
//        Khi k dung mapper :
//        User user = new User(request.getName(), request.getRole(), request.getAge(),request.getPermissions());

//        Khi su dung mapper :
        User user1 = modelMapper.map(request,User.class);
        userRepository.save(user1);
    }

    @Override
    public List<User> findUserByPermissionId(Long id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        if(permission.isPresent()){
            return userRepository.findByPermissions(permission.get());
        }
        return null;
    }
}
