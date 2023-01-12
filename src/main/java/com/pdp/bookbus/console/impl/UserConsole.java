package com.pdp.bookbus.console.impl;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

import java.util.Scanner;

public class UserConsole implements IConsole {
    @Override
    public void openConsole(User user) {
        while (true){
            Scanner scanner = new Scanner(System.in);
        }
    }

    private static UserConsole userConsole;

    public static UserConsole getInstance() {
        if (userConsole == null) {
            userConsole = new UserConsole();
        }
        return userConsole;
    }
}
