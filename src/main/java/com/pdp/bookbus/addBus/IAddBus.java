package com.pdp.bookbus.addBus;

import com.pdp.bookbus.model.Bus;
import com.pdp.bookbus.storage.Storage;

import java.util.Scanner;

public class IAddBus implements AddBus {
    private static AddBus addBus;

    public static AddBus getInstance() {
        if (addBus == null) {
            addBus = new IAddBus();
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
        Bus bus1 = Storage.busList.stream().filter(bus -> bus.getNumber().equals(busNumber)).findFirst().orElse(null);
        if (bus1 == null) {
            System.out.println("Bus seats number: ");
            int seats = scanner.nextInt();
            System.out.println("Active or no Active (true/false): ");
            boolean isActive = scanner.hasNext();
            Bus bus = new Bus(Bus.currentId, busName, busNumber, seats, isActive);
            Storage.busList.add(bus);
            System.out.println("Add succesfully");

            //admin console
        } else {
            System.out.println("We have this bus");

            //admin console
        }
    }
}
