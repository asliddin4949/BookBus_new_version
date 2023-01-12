package com.pdp.bookbus.service;

import com.pdp.bookbus.model.Travel;
import com.pdp.bookbus.model.TravelStatus;

import java.util.Scanner;

import static com.pdp.bookbus.storage.Storage.ticketList;
import static com.pdp.bookbus.storage.Storage.travelList;

public class IShowTravelsForUser implements ShowTravelsForUser {

    public static ShowTravelsForUser showTravelsForUser;

    public static ShowTravelsForUser getInstance() {
        if (showTravelsForUser == null) {
            showTravelsForUser = new IShowTravelsForUser();
        }
        return showTravelsForUser;
    }


    @Override
    public void showTravelsForUser() {

        System.out.println("Show Travels");
        System.out.println("*****************************************");
        for (Travel travel : travelList) {
            if (travel.getStatus().equals(TravelStatus.NEW)) {
                System.out.println("Travel Id " + travel.getId());
                System.out.println("Travel name " + travel.getName());
                System.out.println("Travel from " + travel.getFrom() + "   to " + travel.getTo());
                System.out.println("Departure time: " + travel.getDepartureTime() + "   Arrival time: " + travel.getArrivalTime());
                System.out.println("Price: " + travel.getPriceForPerSeat());
                System.out.println("Status: " + travel.getStatus());
                System.out.println("Created time: " + travel.getCreatedTime());
                System.out.println("ID Buss: " + travel.getBus().getId() + "  Buss name: " + travel.getBus().getName());
                System.out.println("*****************************************");
            }
        }
        System.out.println("Enter Travel Id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Travel travel1 = travelList.stream().filter(travel -> travel.getId() == id).findFirst().orElse(null);
        if (travel1 == null) {
            return;
        }
        System.out.println("*****************************************");
        ticketList.stream().filter(ticket -> ticket.getTravel().equals(travel1)).forEach(ticket -> {
            System.out.println("Seat number: " + ticket.getSeatNumber());
            System.out.println("Price: " + ticket.getPrice());
            System.out.println("Status seat: " + ticket.getStatus());
            System.out.println("*****************************************");
        });


    }
}
