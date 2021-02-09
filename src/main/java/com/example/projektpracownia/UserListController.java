package com.example.projektpracownia;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserListController {
    private final List<UserModel> users;

    public UserListController(){
        users = new ArrayList<>();

        users.add(new UserModel("Jan", "Kowalski", "23.02.1994", "jankowalski94"));
        users.add(new UserModel("Krystyna", "Śląska", "01.10.1989", "kslaska11"));
        users.add(new UserModel("Roman", "Czarodziej", "12.12.2002", "czaroman2"));
        users.add(new UserModel("Kinga", "Michalska", "15.05.1979", "k.michalska"));
        users.add(new UserModel("Edward", "Nożycoręki", "31.01.1955", "edzionozyce"));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserModel> getAll(){
        return users;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<UserModel> add(@RequestBody UserModel userModel){
        users.add(userModel);

        return users;
    }

}
