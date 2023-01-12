package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bus {
    private int id;
    String name;
    String number;
    int numberOfSeats;
    boolean isActive;

    public static int currentId = 1;

    {
        currentId++;
    }
}
