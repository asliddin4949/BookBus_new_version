package com.pdp.bookbus.console.adminoperands;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

public class TicketOperandConsole implements IConsole {

    @Override
    public void openConsole(User user) {
        while (true) {

        }
    }

    private static TicketOperandConsole ticketOperandConsole;

    public static TicketOperandConsole getInstance() {
        if (ticketOperandConsole == null) {
            ticketOperandConsole = new TicketOperandConsole();
        }
        return ticketOperandConsole;
    }
}
