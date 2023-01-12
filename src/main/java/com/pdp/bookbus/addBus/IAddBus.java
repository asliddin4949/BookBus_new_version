package com.pdp.bookbus.addBus;

import com.pdp.bookbus.model.Bus;
import com.pdp.bookbus.storage.Storage;

import java.util.Scanner;

public class IAddBus implements BusService {
    private static BusService addBus;

    public static BusService getInstance() {
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
            Bus bus = new Bus(Bus.currentId, busName, busNumber, seats, true);
            Storage.busList.add(bus);
            System.out.println("Add succesfully");

            //admin console
        } else {
            System.out.println("We have this bus");

            //admin console
        }
    }
}
