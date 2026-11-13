package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    public void display () {
        Scanner userInput = new Scanner(System.in);
        String userText = "";
        init();
        do {
            System.out.println("""
                    1.Find vehicles within a price range
                    2.Find vehicles by make / model
                    3.Find vehicles by year range
                    4.Find vehicles by color
                    5.Find vehicles by mileage range
                    6.Find vehicles by type (car, truck, SUV, van)
                    7.List ALL vehicles
                    8.Add a vehicle
                    9.Remove a vehicle
                    99.Quit
                    """);
            userText = userInput.nextLine();
            switch (userText) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehicleRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> System.out.println("Exiting");
                default -> System.out.println("Not an option. Please try again.");
            }
        } while (!userText.equals("99"));
        userInput.close();
    }

    private void init () {
        this.dealership = DealerShipManager.getDealerShip();
    }

    private void displayVehicles (ArrayList<Vehicle> vehiclesRequest) {
        for (Vehicle currentVehicle : vehiclesRequest) {
            currentVehicle.display();
        }
    }

    private void processGetByPriceRequest () {

    }

    private void processGetByMakeModelRequest () {

    }

    private void processGetByYearRequest () {

    }

    private void processGetByColorRequest () {

    }

    private void processGetByMileageRequest () {

    }

    private void processGetByVehicleTypeRequest () {

    }

    private void processGetAllVehicleRequest () {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest () {

    }

    private void processRemoveVehicleRequest () {

    }

}
