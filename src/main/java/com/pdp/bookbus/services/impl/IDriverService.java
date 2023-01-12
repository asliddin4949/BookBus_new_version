package com.pdp.bookbus.services.impl;


import com.pdp.bookbus.model.Role;
import com.pdp.bookbus.model.User;
import com.pdp.bookbus.services.interfaces.DriverService;
import com.pdp.bookbus.storage.Storage;

public class IDriverService implements DriverService {
    private static IDriverService add_Driver;

    public static IDriverService getInstance() {
        if (add_Driver == null) {
            add_Driver = new IDriverService();
        }
        return add_Driver;
    }

    public void addDriver() {
        User user = ISignInSignUp.getInstance().signUp();
        for (User user1 : Storage.userList) {
            if (user1.equals(user)) {
                user1.setRole(Role.DRIVER);
            }
        }
    }
}
