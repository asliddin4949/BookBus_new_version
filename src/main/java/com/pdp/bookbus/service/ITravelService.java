package com.pdp.bookbus.service;

import com.pdp.bookbus.model.*;
import com.pdp.bookbus.storage.Storage;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.LocalDateTime.parse;

public class ITravelService implements TravelService{
    private static TravelService travelService;
    public static TravelService getInstance(){
        if (travelService == null){
            travelService = new ITravelService();
        }
        return travelService;
    }


    @Override
    public void addTravel() {
        while (true) {
            System.out.print("Do you want Continue  [y/n] :");
            Scanner scanner = new Scanner(System.in);
            String com = scanner.nextLine();
            if (com.equalsIgnoreCase("y")) {
                System.out.print("Enter Travel Name:  ");
                scanner = new Scanner(System.in);
                String enteredName = scanner.nextLine();
                Travel checkTravelName = Storage.travelList.stream()
                        .filter(t -> t.getName().equalsIgnoreCase(enteredName))
                        .findFirst().orElse(null);
                if (checkTravelName == null){
                    System.out.print("From:  ");
                    scanner = new Scanner(System.in);
                    String enteredFrom = scanner.nextLine();
                    System.out.print("To:  ");
                    scanner = new Scanner(System.in);
                    String enteredTo = scanner.nextLine();

                    while (true) {
                        LocalDateTime startTime = getTime("start");

                        LocalDateTime finishTime = getTime("finish");
                            System.out.println("**********  Bus list  **********");
                            Storage.busList.forEach(System.out::println);
                            System.out.print("Select Bus Id:  ");
                            scanner = new Scanner(System.in);
                            int selectedBusID = scanner.nextInt();
                                Bus chosenBus = checkBusId(selectedBusID);
                                if (chosenBus != null){
                                    System.out.println("Successfully Bus Selected");
                                }
                                else {
                                    System.out.println("Wrong Selected ID");
                                    break;
                                }

                                System.out.println("**********  Driver list  **********");
                                for (int i = 0; i < Storage.userList.size(); i++) {
                                    if (Storage.userList.get(i).getRole().equals(Role.DRIVER)){
                                        System.out.println(Storage.userList.get(i));
                                    }
                                }
                                System.out.print("Select Driver Id:  ");
                                scanner = new Scanner(System.in);
                                int selectedDriverID = scanner.nextInt();
                                    User chosenDriver = checkDriverId(selectedDriverID);
                                    if (chosenDriver != null) {
                                        System.out.println("Successfully Driver Selected");
                                    }
                                    else {
                                        System.out.println("Wrong Selected Id");
                                        break;
                                    }
                                    System.out.print("Enter Price for Per Seat:  ");
                                    scanner = new Scanner(System.in);
                                    BigDecimal enteredPrice = BigDecimal.valueOf(scanner.nextInt());
                                    LocalDateTime createdTime = LocalDateTime.now();
                                    Travel travel = new Travel(Travel.currentId, enteredName, enteredFrom, enteredTo, startTime, finishTime,
                                           chosenBus, chosenDriver, enteredPrice, TravelStatus.NEW, createdTime);
                                    Storage.travelList.add(travel);
                                    System.out.println("Successfully added");
                                    break;
                    }
                }
                else {
                    System.out.println("Already added this travel");
                }
            } else if (com.equalsIgnoreCase("n")){
                break;
            } else {
                System.out.println("Wrong Command!!!");
            }
        }
    }
    private User checkDriverId(int selectedDriverID) {
        return Storage.userList.stream()
                .filter(driver -> driver.getId()==selectedDriverID)
                .findFirst().orElse(null);
    }
    private Bus checkBusId(int selectedBusID) {
        return Storage.busList.stream()
                .filter(bus -> bus.getId()==selectedBusID)
                .findFirst().orElse(null);
    }
    public static LocalDateTime getTime(String cause) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String departureTime;
        while (true) {
            System.out.printf(" Enter Travel's %s time: (dd.MM.yyyy HH:mm:ss)  --> Example:  31.12.2022 23:59:59 %n", cause);
            Scanner scanner = new Scanner(System.in);
            departureTime = scanner.nextLine();
            try {
                return parse(departureTime, formatter);
            } catch (RuntimeException e) {
                System.out.println("Wrong date or time format");
            }
        }
    }
}
