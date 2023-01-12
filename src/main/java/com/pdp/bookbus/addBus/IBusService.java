package com.pdp.bookbus.addBus;

import com.pdp.bookbus.model.Bus;
import com.pdp.bookbus.storage.Storage;

import java.awt.*;
import java.util.Scanner;

public class IBusService implements BusService {
    private static BusService addBus;

    public static BusService getInstance() {
        if (addBus == null) {
            addBus = new IBusService();
        }
        return addBus;
    }

    @Override
    public void addBusInAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bus name: ");
        String busName = scanner.next();
        System.out.println("Bus number: ");
        String busNumber = scanner.next();
        Bus bus1 = Storage.busList.stream().filter(bus ->
                bus.getNumber().equals(busNumber)).findFirst().orElse(null);
        if (bus1 == null) {
            System.out.println("Bus seats number: ");
            int seats = scanner.nextInt();
            Bus bus = new Bus(Bus.currentId, busName, busNumber, seats, true);
            Storage.busList.add(bus);
            System.out.println("Add succesfully");

            //admin console
        } else {
            System.out.println("We have this bus");

            //admin console
        }
    }

    @Override
    public void editBus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buses:");
        for (Bus bus : Storage.busList) {
            System.out.println(bus);
        }
        System.out.print("Bus id: ");
        int id = scanner.nextInt();
        Bus bus1 = Storage.busList.stream().filter(bus ->
                bus.getId() == id).findFirst().orElse(null);
        if (bus1 == null) {
            System.out.println("The id was entered incorrectly!");
        } else {
            System.out.println("Which field do you want to change?");
            System.out.println("'1'-\"Bus name\" '2'-\"Bus number\" '3'-\"Bus seats number\" '4'-\"isActive\"");
            int com = scanner.nextInt();
            if (com == 1) {
                scanner = new Scanner(System.in);
                System.out.print("New Bus name: ");
                String name = scanner.nextLine();
                bus1.setName(name);
                System.out.println("Name changed successfully!");
            } else if (com == 2) {
                System.out.print("New Bus number: ");
                String number = scanner.nextLine();
                bus1.setNumber(number);
                System.out.println("Number changed successfully!");
            } else if (com == 3) {
                scanner = new Scanner(System.in);
                System.out.print("New Bus seats number: ");
                int numberOfSeats = scanner.nextInt();
                bus1.setNumberOfSeats(numberOfSeats);
                System.out.println("Seats number changed successfully!");
            } else if (com == 4) {
                bus1.setActive(false);
                System.out.println("IsAvtive changed successfully!");
            } else {
                System.out.println("An error command was entered!");
            }
        }
    }
}
