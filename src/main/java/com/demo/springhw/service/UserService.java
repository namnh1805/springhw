package com.demo.springhw.service;

import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getListUser ();
    Page<User> getPageUser (int page,int size);
    void createUser(CreateUserDTO request);
    List<User>  findUserByPermissionId(Long id);
}
