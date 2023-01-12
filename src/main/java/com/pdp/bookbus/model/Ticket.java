package com.pdp.bookbus.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && seatNumber == ticket.seatNumber && Objects.equals(travel, ticket.travel) && Objects.equals(price, ticket.price) && status == ticket.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, travel, price, seatNumber, status);
    }

    @Override
    public String toString() {
        return "Ticket{ " +
                "id: " + id +
                ", travel: " + travel +
                ", price: " + price +
                ", seatNumber: " + seatNumber +
                ", status: " + status +
                '}';
    }
}
