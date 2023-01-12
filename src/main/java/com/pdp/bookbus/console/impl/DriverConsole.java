package com.pdp.bookbus.console.impl;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

import java.util.Scanner;

public class DriverConsole implements IConsole {
    @Override
    public void openConsole(User driver) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - show my travels   '2' - change travel status  '3' - finished travels  '0' - exit");
            int command = scanner.nextInt();
            if (command == 1) {

            } else if (command == 2) {

            } else if (command == 3) {

            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static DriverConsole driverConsole;

    public static DriverConsole getInstance() {
        if (driverConsole == null) {
            driverConsole = new DriverConsole();
        }
        return driverConsole;
    }
}
