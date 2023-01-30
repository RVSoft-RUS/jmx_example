package com.example.jmx_example.accountServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountServer {
    private int usersLimit = 10;
    private int users = 0;

    public void setUsersLimit(int usersLimit) {
        System.out.println("Setup usersLimit");
        this.usersLimit = usersLimit;
    }

    public int getUsers() {
        System.out.println("Запрос users");
        return users;
    }

    public void setUsers(int users) {
        System.out.println("Setup users");
        this.users = users;
    }

    @GetMapping("/admin")
    public int getUsersLimit() {
        System.out.println("Запрос usersLimit");
        return usersLimit;
    }
}
