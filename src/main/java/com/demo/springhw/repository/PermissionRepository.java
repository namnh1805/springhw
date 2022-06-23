package com.demo.springhw.repository;

import com.demo.springhw.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByAction(String action);

    Permission findById(long id);
}