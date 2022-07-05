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

import java.util.ArrayList;
import java.util.List;
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

                Permission permissionA = new Permission("access DB");
                Permission permissionB = new Permission("access git");
                Permission permissionC = new Permission("access network");


                User userA = new User("Nam Nguyen","admin",17,Set.of(permissionA,permissionB,permissionC));
                User userB = new User("Nam Nguyen 2","member",18,Set.of(permissionA,permissionB));
                User userC = new User("Nam Nguyen 3","super admin",19,Set.of(permissionB,permissionC));
                User userD = new User("Nam Nguyen 4","sub-admin",20,Set.of(permissionA));
                User userE = new User("Nam Nguyen5","admin",17,Set.of(permissionA,permissionB,permissionC));
                User userF = new User("Nam Nguyen 6","member",18,Set.of(permissionA,permissionB));
                User userG = new User("Nam Nguyen 7","super admin",19,Set.of(permissionB,permissionC));
                User userH = new User("Nam Nguyen 8","sub-admin",20,Set.of(permissionA));
                User userI = new User("Nam Nguyen9","admin",17,Set.of(permissionA,permissionB,permissionC));
                User userK = new User("Nam Nguyen 12","member",18,Set.of(permissionA,permissionB));
                User userL = new User("Nam Nguyen 13","super admin",19,Set.of(permissionB,permissionC));
                User userM = new User("Nam Nguyen 14","sub-admin",20,Set.of(permissionA));
                User userN = new User("Nam Nguyen15","admin",17,Set.of(permissionA,permissionB,permissionC));
                User userO = new User("Nam Nguyen 22","member",18,Set.of(permissionA,permissionB));
                User userP = new User("Nam Nguyen 23","super admin",19,Set.of(permissionB,permissionC));
                User userQ = new User("Nam Nguyen 24","sub-admin",20,Set.of(permissionA));
                User userAa = new User("Nam Nguyen333","admin",17,Set.of(permissionA,permissionB,permissionC));
                User userBb = new User("Nam Nguyen 32","member",18,Set.of(permissionA,permissionB));
                User userCa = new User("Nam Nguyen 33","super admin",19,Set.of(permissionB,permissionC));
                User userDa = new User("Nam Nguyen 34","sub-admin",20,Set.of(permissionA));

                logger.info("insert data: "+permissionRepository.save(permissionA));
                logger.info("insert data: "+permissionRepository.save(permissionB));
                logger.info("insert data: "+permissionRepository.save(permissionC));
                logger.info("--------------------");
                logger.info("insert data: "+userRepository.save(userA));
                logger.info("insert data: "+userRepository.save(userB));
                logger.info("insert data: "+userRepository.save(userC));
                logger.info("insert data: "+userRepository.save(userD));
                logger.info("insert data: "+userRepository.save(userE));
                logger.info("insert data: "+userRepository.save(userD));
                logger.info("insert data: "+userRepository.save(userF));
                logger.info("insert data: "+userRepository.save(userG));
                logger.info("insert data: "+userRepository.save(userH));
                logger.info("insert data: "+userRepository.save(userI));
                logger.info("insert data: "+userRepository.save(userK));
                logger.info("insert data: "+userRepository.save(userL));
                logger.info("insert data: "+userRepository.save(userM));
                logger.info("insert data: "+userRepository.save(userN));
                logger.info("insert data: "+userRepository.save(userO));
                logger.info("insert data: "+userRepository.save(userP));
                logger.info("insert data: "+userRepository.save(userQ));
                logger.info("insert data: "+userRepository.save(userAa));
                logger.info("insert data: "+userRepository.save(userBb));
                logger.info("insert data: "+userRepository.save(userCa));
                logger.info("insert data: "+userRepository.save(userDa));
            }
        };
    }
}
