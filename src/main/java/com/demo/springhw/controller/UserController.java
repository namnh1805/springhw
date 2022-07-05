package com.demo.springhw.controller;


import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.Permission;
import com.demo.springhw.entity.ResponseObject;
import com.demo.springhw.entity.User;
import com.demo.springhw.repository.PermissionRepository;
import com.demo.springhw.repository.UserRepository;
import com.demo.springhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Value("${pagination.page}")
    String page;
    @Value("${pagination.size}")
    String size;
    @Value("${pagination.readFromFile}")
    String readFromFile;


    @GetMapping
    public ResponseObject getListUser() {
        return new ResponseObject("OK", "List data", userService.getListUser());
    }

    @PostMapping
    public ResponseObject createUser(@RequestBody CreateUserDTO request) {
        userService.createUser(request);
        return new ResponseObject("OK", "Creat user success ",null );
    }

    @GetMapping("/permission-header")
    public ResponseObject getPermissionHeader(@RequestHeader (name = "permission_id") Long id) {
        return new ResponseObject("OK", "List data", userService.findUserByPermissionId(id));
    }

    @GetMapping("/test-page")
    public ResponseObject getPageUser(@RequestParam (value = "pageParam" ,required = false) Integer pageParam,
                                      @RequestParam (value= "sizeParam",required = false) Integer sizeParam){

        if("true".equals(readFromFile)){
            return new ResponseObject(System.getenv("status"), "List data", userService.getPageUser(Integer.parseInt(page),Integer.parseInt(size)));
        }else{
            return new ResponseObject(System.getenv("status"), "List data", userService.getPageUser(pageParam,sizeParam));
        }
    }
}
