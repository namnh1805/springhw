package com.demo.springhw.database;

import com.demo.springhw.entity.Permission;
import com.demo.springhw.entity.User;
import com.demo.springhw.repository.PermissionRepository;
import com.demo.springhw.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PermissionRepository permissionRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User userA = new User("Nam Nguyen","admin",17);
                User userB = new User("Nam Nguyen 2","member",18);
                User userC = new User("Nam Nguyen 3","super admin",19);
                User userD = new User("Nam Nguyen 4","sub-admin",20);
                Permission permissionA = new Permission("access DB");
                Permission permissionB = new Permission("access git");
                Permission permissionC = new Permission("access network");

                logger.info("insert data: "+permissionRepository.save(permissionA));
                logger.info("insert data: "+permissionRepository.save(permissionB));
                logger.info("insert data: "+permissionRepository.save(permissionC));
                userA.setPermissions(Set.of(permissionA,permissionB,permissionC));
                userB.setPermissions(Set.of(permissionA,permissionB));
                userC.setPermissions(Set.of(permissionB,permissionC));
                userD.setPermissions(Set.of(permissionA));
//                userA.getPermissions().add(permissionA);
//                userA.getPermissions().add(permissionB);
//                userB.getPermissions().add(permissionC);
//                userC.getPermissions().add(permissionC);
                logger.info("--------------------");
                logger.info("insert data: "+userRepository.save(userA));
                logger.info("insert data: "+userRepository.save(userB));
                logger.info("insert data: "+userRepository.save(userC));
                logger.info("insert data: "+userRepository.save(userD));



            }
        };
    }
}
