package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Reserve {
    private int id;
    User user;
    LocalDateTime createdTime;
    Ticket ticket;
    private BigDecimal cost;

    public static int currentId = 1;

    {
        currentId++;
    }
}
