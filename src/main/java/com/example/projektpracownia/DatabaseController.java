package com.example.projektpracownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseController implements CommandLineRunner {
    private final UserListRepository userListRepository;

    @Autowired
    public DatabaseController(UserListRepository userListRepository){
        this.userListRepository = userListRepository;
    }

    @Override
    public void run(String... args) {
        List <UserModel> users = new ArrayList<>();

        users.add(new UserModel("Jan", "Kowalski", "23.02.1994", "jankowalski94"));
        users.add(new UserModel("Krystyna", "Nowak", "01.10.1989", "knowak11"));
        users.add(new UserModel("Roman", "Wiśniewski", "12.12.2002", "romanwisnia2"));
        users.add(new UserModel("Kinga", "Michalska", "15.05.1979", "k.michalska"));
        users.add(new UserModel("Lucek", "Niziołek", "31.01.1955", "lucek#niziolek"));

        userListRepository.saveAll(users);
    }
}
