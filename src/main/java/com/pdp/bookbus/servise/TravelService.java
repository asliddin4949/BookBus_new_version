package com.pdp.bookbus.servise;

import com.pdp.bookbus.model.Ticket;
import com.pdp.bookbus.model.Travel;
import com.pdp.bookbus.storage.Storage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TravelService {

    static Scanner scannerInt = new Scanner(System.in);

    public void getInformationForAdmin(){
        System.out.println(" Firstly, you must choose travel -->");
        if (Storage.travelList.size() == 0){
            System.out.println(" Travel list is empty ");
        } else {
            Travel travel = chosenTravelForInformation();
            if (travel == null){
                System.out.println(" chosen Travel is not found ");
            } else {
                System.out.println(" Travel's name: " + travel.getName());
                System.out.println(" From: " + travel.getFrom());
                System.out.println(" To: " + travel.getTo());
                System.out.println(" Travel's driver: \n" + travel.getDriver());
                System.out.println(" Travel's departureTime: " + travel.getDepartureTime());
                System.out.println(" Travel's arrivalTime: " + travel.getArrivalTime());
                System.out.println(" Travel's Bus: \n" + travel.getBus());
                List<Ticket> tickets = Storage.ticketList.stream()
                        .filter(ticket -> ticket.getTravel().equals(travel)).toList();
                System.out.println(" Tickets for Travel: \n");
                tickets.forEach(ticket -> {
                    System.out.println(ticket.toString());
                    System.out.println(" + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + ");
                });
                createExcel(travel, tickets);

            }
        }
    }

    private void createExcel(Travel travel, List<Ticket> tickets) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        try (FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\getInformation.xlsx")) {

            XSSFSheet travels = workbook.createSheet("travels");
            XSSFRow row = travels.createRow(0);
            row.createCell(0).setCellValue("About travel");
            XSSFRow row1 = travels.createRow(1);
            row1.createCell(0).setCellValue("Name ");
            row1.createCell(1).setCellValue(travel.getName());
            XSSFRow row2 = travels.createRow(1);
            row2.createCell(0).setCellValue("From ");
            row2.createCell(1).setCellValue(travel.getFrom());
            XSSFRow row3 = travels.createRow(2);
            row3.createCell(0).setCellValue("To ");
            row3.createCell(1).setCellValue(travel.getTo());
            XSSFRow row4 = travels.createRow(3);
            row4.createCell(0).setCellValue("Driver ");
            row4.createCell(1).setCellValue(travel.getDriver().getId());
            row4.createCell(2).setCellValue(travel.getDriver().getName());
            row4.createCell(3).setCellValue(travel.getDriver().getUsername());
            row4.createCell(4).setCellValue(travel.getDriver().getPassword());
            XSSFRow row5 = travels.createRow(4);
            row5.createCell(0).setCellValue("DepartureTime ");
            row5.createCell(1).setCellValue(travel.getDepartureTime());
            XSSFRow row6 = travels.createRow(5);
            row6.createCell(0).setCellValue("ArrivalTime ");
            row6.createCell(1).setCellValue(travel.getArrivalTime());
            XSSFRow row7 = travels.createRow(6);
            row7.createCell(0).setCellValue("Bus ");
            row7.createCell(1).setCellValue(travel.getBus().getId());
            row7.createCell(2).setCellValue(travel.getBus().getName());
            row7.createCell(3).setCellValue(travel.getBus().getNumber());
            row7.createCell(4).setCellValue(travel.getBus().getNumberOfSeats());
            XSSFRow row8 = travels.createRow(7);
            row8.createCell(0).setCellValue("Ticket ");
            row8.createCell(1).setCellValue("Ticket ");
            row8.createCell(2).setCellValue("Ticket ");
            row8.createCell(3).setCellValue("Ticket ");
            XSSFRow row9 = travels.createRow(8);
            row9.createCell(0).setCellValue(" Id ");
            row9.createCell(1).setCellValue(" Price ");
            row9.createCell(2).setCellValue(" SeatNumber ");
            row9.createCell(3).setCellValue(" Status ");
            int rowNum = 9;
            XSSFRow row10;
            for (Ticket ticket : tickets) {
                row10 = travels.createRow(rowNum);
                row10.createCell(0).setCellValue(ticket.getId());
                row10.createCell(1).setCellValue(String.valueOf(ticket.getPrice()));
                row10.createCell(2).setCellValue(ticket.getSeatNumber());
                row10.createCell(3).setCellValue(String.valueOf(ticket.getStatus()));
                rowNum ++;
            }
            System.out.println(" Start create Excel! ");
            workbook.write(outputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" Successfully, Excel created for information");

    }

    private Travel chosenTravelForInformation() {
        Storage.travelList.forEach(travel -> {
            System.out.println(travel.toString());
            System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        });
        System.out.println(" Enter chosen Travel's ID: ");
        int chosen = scannerInt.nextInt();
        return Storage.travelList.stream()
                .filter(travel -> travel.getId() == chosen)
                .findFirst().orElse(null);
    }


    static TravelService travel00;

    public static TravelService getTravel00() {
        if (travel00 == null){
            travel00 = new TravelService();
        }
        return travel00;
    }
}
