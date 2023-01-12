package com.pdp.bookbus.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {
    private int id;
    String name;
    private String username;
    private String password;
    Role role;
    private BigDecimal balance;
    boolean isActive;

    public User(int id, String name, String username, String password, Role role, BigDecimal balance, boolean isActive) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.isActive = isActive;
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
