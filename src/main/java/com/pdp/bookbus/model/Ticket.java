package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ticket {
    private int id;
    Travel travel;
    private BigDecimal price;
    int seatNumber;
    TicketStatus status;

    public static int currentId = 1;

    {
        currentId++;
    }

}
