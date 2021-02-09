package com.example.projektpracownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserListController {

    private final UserListRepository userListRepository;

    @Autowired
    public UserListController(UserListRepository userListRepository){
        this.userListRepository = userListRepository;
    }

    @GetMapping(value = "/all")
    public List<UserModel> getAll(){
        return userListRepository.findByisDeletedFalse();
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public List<UserModel> add(@RequestBody UserModel userModel){
        userListRepository.save(userModel);

        return userListRepository.findByisDeletedFalse();
    }

    @GetMapping(value = "/delete/{id}")
    public List<UserModel> remove(@PathVariable long id){
        userListRepository.delete(id);

        return userListRepository.findByisDeletedFalse();
    }

}
