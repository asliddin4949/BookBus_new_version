package com.pdp.bookbus.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public Travel() {
    }

    public Travel(int id, String name, String from, String to, LocalDateTime departureTime, LocalDateTime arrivalTime, Bus bus, User driver, BigDecimal priceForPerSeat, TravelStatus status, LocalDateTime createdTime) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.bus = bus;
        this.driver = driver;
        this.priceForPerSeat = priceForPerSeat;
        this.status = status;
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return id == travel.id && Objects.equals(name, travel.name) && Objects.equals(from, travel.from) && Objects.equals(to, travel.to) && Objects.equals(departureTime, travel.departureTime) && Objects.equals(arrivalTime, travel.arrivalTime) && Objects.equals(bus, travel.bus) && Objects.equals(driver, travel.driver) && Objects.equals(priceForPerSeat, travel.priceForPerSeat) && status == travel.status && Objects.equals(createdTime, travel.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, from, to, departureTime, arrivalTime, bus, driver, priceForPerSeat, status, createdTime);
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", bus=" + bus +
                ", driver=" + driver +
                ", priceForPerSeat=" + priceForPerSeat +
                ", status=" + status +
                ", createdTime=" + createdTime +
                '}';
    }
}
