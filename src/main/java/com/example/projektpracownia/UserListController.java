package com.example.projektpracownia;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserModel> showAll(){
        return userListRepository.findByisDeletedFalse();
    }

    @PostMapping(value = "/allcheat")
    public List<UserModel> showEveryone(){
        return userListRepository.findAll();
    }

    @PostMapping(value = "/all/{id}")
    public Optional<UserModel> showOne(@PathVariable long id){
        return userListRepository.findById(id);
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public List<UserModel> add(@RequestBody UserModel userModel){
        userListRepository.save(userModel);

        return userListRepository.findByisDeletedFalse();
    }

    @PostMapping(value = "/delete/{id}")
    public List<UserModel> remove(@PathVariable long id){
        userListRepository.delete(id);

        return userListRepository.findByisDeletedFalse();
    }

    @PostMapping(value = "/undo/{id}")
    public List<UserModel> undoRemove(@PathVariable long id){
        userListRepository.undoDelete(id);

        return userListRepository.findByisDeletedFalse();
    }

    @PutMapping(value = "/update")
    public List<UserModel> update(@RequestBody UserModel userModel){
        userListRepository.save(userModel);

        return userListRepository.findByisDeletedFalse();
    }

}
