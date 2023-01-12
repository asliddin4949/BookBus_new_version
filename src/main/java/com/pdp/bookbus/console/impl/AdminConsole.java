package com.pdp.bookbus.console.impl;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.console.adminoperands.BusOperandConsole;
import com.pdp.bookbus.console.adminoperands.DriverOperandConsole;
import com.pdp.bookbus.console.adminoperands.TicketOperandConsole;
import com.pdp.bookbus.console.adminoperands.TravelOperandConsole;
import com.pdp.bookbus.model.User;

import java.util.Scanner;

public class AdminConsole implements IConsole {

    @Override
    public void openConsole(User user) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - bus operations  '2' - driver operations  '0' - exit" +
                    "'3' - travel operations '4' - ticket operations ");
            int command = scanner.nextInt();
            if (command == 1) {
                BusOperandConsole.getInstance().openConsole(user);
            } else if (command == 2) {
                DriverOperandConsole.getInstance().openConsole(user);
            } else if (command == 3) {
                TravelOperandConsole.getInstance().openConsole(user);
            } else if (command == 4) {
                TicketOperandConsole.getInstance().openConsole(user);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static AdminConsole adminConsole;

    public static AdminConsole getInstance() {
        if (adminConsole == null) {
            adminConsole = new AdminConsole();
        }
        return adminConsole;
    }
}
