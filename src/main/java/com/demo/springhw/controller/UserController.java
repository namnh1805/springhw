package com.demo.springhw.controller;


import com.demo.springhw.DTO.CreateUserDTO;
import com.demo.springhw.entity.Document;
import com.demo.springhw.entity.ResponseObject;
import com.demo.springhw.entity.User;
import com.demo.springhw.repository.DocumentRepository;
import com.demo.springhw.repository.UserRepository;
import com.demo.springhw.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DocumentRepository documentRepository;

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
    public ResponseObject getPageUser(@RequestParam (value = "pageParam" ,defaultValue = "0",required = false) Integer pageParam,
                                      @RequestParam (value= "sizeParam",defaultValue = "5" ,required = false) Integer sizeParam){

        if("true".equals(readFromFile)){
            return new ResponseObject(System.getenv("status"), "List data", userService.getPageUser(Integer.parseInt(page),Integer.parseInt(size)));
        }else{
            return new ResponseObject(System.getenv("status"), "List data", userService.getPageUser(pageParam,sizeParam));
        }
    }


    //persist, save 1 entity-> save related entity
    @GetMapping("/test-persist")
    public ResponseObject testPersist() {
        Document b = new Document();
        b.setDocumentName("persist");

        User a = new User();
        a.setAge(12);
        a.setName("persist");
        a.setDocument(b);
        userRepository.save(a);

        System.out.println(documentRepository.findAll());
        return new ResponseObject("OK", " data", a);
    }

    //MERGE : Merge trong JPA-Hibernate gi??p h???p nh???t detached entity v???i persistent entity c?? c??ng m??
    // ?????nh danh. Cascade.Merge s??? lan truy???n ho???t ?????ng n??y sang c??c related entity.

    @GetMapping("/test-merge")
    public ResponseObject testMerge() {
        User a = new User();
        a.setAge(12);
        a.setName("persist");
        Document b = new Document();
        b.setDocumentName("merge");
        a.setDocument(b);
        documentRepository.save(b);
        userRepository.save(a);
        System.out.println(documentRepository.findAll());
        return new ResponseObject("OK", " data", a);
    }

    //REMOVE: khi m???t entity b??? x??a kh???i database th?? c??c related entity c??ng b??? x??a theo.
    @GetMapping("/test-remove")
    public ResponseObject testRemove() {
        userRepository.deleteById(Long.valueOf(4));
        System.out.println(documentRepository.findAll());
        return new ResponseObject("OK", " data","");
    }

}
