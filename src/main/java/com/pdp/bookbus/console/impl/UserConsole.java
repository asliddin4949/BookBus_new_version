package com.pdp.bookbus.console.impl;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

import java.util.Scanner;

public class UserConsole implements IConsole {
    @Override
    public void openConsole(User user) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - show travels  '2' - show buses  '0' - exit" +
                    "\n'3' - buy ticket  '4' - ticket history  '5' - balance  '6' - download ticket");
            int command = scanner.nextInt();
            if (command == 1) {

            } else if (command == 2) {

            } else if (command == 3) {

            } else if (command == 4) {

            } else if (command == 5) {

            } else if (command == 6) {

            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command");
            }
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
