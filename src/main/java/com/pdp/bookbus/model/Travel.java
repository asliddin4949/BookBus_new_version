package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class Travel {
    private int id;
    String name;
    String from;
    String to;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    Bus bus;
    User driver;
    private BigDecimal priceForPerSeat;
    TravelStatus status;
    LocalDateTime createdTime;

    public static int currentId = 1;

    {
        currentId++;
    }
}
