package com.pdp.bookbus.console.adminoperands;

import com.pdp.bookbus.console.IConsole;
import com.pdp.bookbus.model.User;

public class BusOperandConsole implements IConsole {

    @Override
    public void openConsole(User user) {
        while (true){

        }
    }
    private static BusOperandConsole busOperandConsole;

    public static BusOperandConsole getInstance() {
        if (busOperandConsole == null) {
            busOperandConsole = new BusOperandConsole();
        }
        return busOperandConsole;
    }


}
