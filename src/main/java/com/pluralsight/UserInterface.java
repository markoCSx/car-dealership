package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    public void display () {
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
            userText = Util.userPrompt();
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
    }

    private void init () {
        this.dealership = DealerShipManager.getDealerShip();
    }

    private void displayVehicles (ArrayList<Vehicle> vehiclesRequest) {
        System.out.println("Results (Enter anything to exit)");
        for (Vehicle currentVehicle : vehiclesRequest) {
            currentVehicle.display();
        }
        Util.userPrompt();
    }

    private void processGetByPriceRequest () {
        String userText = "";
        BigDecimal min = BigDecimal.ZERO;
        BigDecimal max = new BigDecimal("1000000");
        do {
            try {
                System.out.println("Price Range\nMin:");
                min = new BigDecimal(Util.userPrompt());
                System.out.println("Price Range\nMax:");
                max = new BigDecimal(Util.userPrompt());
                System.out.println(min + " - " + max + " (Y/N)");
                userText = Util.userPrompt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!userText.equalsIgnoreCase("y"));
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest () {
        String make = "";
        String model = "";
        System.out.println("Make: ");
        make = Util.userPrompt();
        System.out.println("Model: ");
        model = Util.userPrompt();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest () {
        String userText = "";
        int yearMin = 0;
        int yearMax = 100000;
        do {
            try {
                System.out.println("Year Range\nMin:");
                yearMin= Integer.parseInt(Util.userPrompt());
                System.out.println("Year Range\nMax:");
                yearMax = Integer.parseInt(Util.userPrompt());
                System.out.println(yearMin + " - " + yearMax + " (Y/N)");
                userText = Util.userPrompt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!userText.equalsIgnoreCase("y"));
        displayVehicles(dealership.getVehiclesByYear(yearMin, yearMax));

    }

    private void processGetByColorRequest () {
        String color = "";
        System.out.println("Color: ");
        color = Util.userPrompt();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest () {
        String userText = "";
        int mileageMin = 0;
        int mileageMax = 1000000;
        do {
            try {
                System.out.println("Mileage Range\nMin:");
                mileageMin = Integer.parseInt(Util.userPrompt());
                System.out.println("Mileage Range\nMax:");
                mileageMax = Integer.parseInt(Util.userPrompt());
                System.out.println(mileageMin + " - " + mileageMax + " (Y/N)");
                userText = Util.userPrompt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!userText.equalsIgnoreCase("y"));
        displayVehicles(dealership.getVehiclesByMileage(mileageMin, mileageMax));
    }

    private void processGetByVehicleTypeRequest () {
        String type = "";
        System.out.println("Vehicle Type: ");
        type = Util.userPrompt();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetAllVehicleRequest () {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest () {

    }

    private void processRemoveVehicleRequest () {

    }

}
