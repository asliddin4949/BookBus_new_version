package com.pdp.bookbus.console.adminoperands;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

public class DriverOperandConsole implements IConsole {
    @Override
    public void openConsole(User user) {
        while (true) {

        }
    }

    private static DriverOperandConsole driverOperandConsole;

    public static DriverOperandConsole getInstance() {
        if (driverOperandConsole == null) {
            driverOperandConsole = new DriverOperandConsole();
        }
        return driverOperandConsole;
    }
}
