package com.pdp.bookbus.storage;

import com.pdp.bookbus.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<User> userList = new ArrayList<>();
    public static User admin = new User(0, "Mr.Admin", "admin", "123", Role.ADMIN, BigDecimal.ZERO, true);
    public static List<Bus> busList = new ArrayList<>();
    public static List<Reserve> reserveList = new ArrayList<>();
    public static List<Travel> travelList = new ArrayList<>();
    public static List<Ticket> ticketList = new ArrayList<>();

}
