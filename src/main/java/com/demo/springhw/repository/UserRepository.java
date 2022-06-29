package com.demo.springhw.repository;

import java.util.List;

import com.demo.springhw.entity.Permission;
import com.demo.springhw.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    List<User> findByPermissions(Permission permission);

}