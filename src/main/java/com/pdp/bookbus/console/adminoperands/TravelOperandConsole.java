package com.pdp.bookbus.console.adminoperands;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

public class TravelOperandConsole implements IConsole {

    @Override
    public void openConsole(User user) {
        while (true) {

        }
    }

    private static TravelOperandConsole travelOperandConsole;

    public static TravelOperandConsole getInstance() {
        if (travelOperandConsole == null) {
            travelOperandConsole = new TravelOperandConsole();
        }
        return travelOperandConsole;
    }
}
