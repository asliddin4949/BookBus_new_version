package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    public Bus(int currentId, String name, String number, int numberOfSeats, boolean isActive) {
        this.id = currentId;
        this.name = name;
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.isActive = isActive;
    }

    public Bus() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id == bus.id && numberOfSeats == bus.numberOfSeats && isActive == bus.isActive && Objects.equals(name, bus.name) && Objects.equals(number, bus.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, numberOfSeats, isActive);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", isActive=" + isActive +
                '}';
    }
}
