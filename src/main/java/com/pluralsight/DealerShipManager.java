package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class DealerShipManager {

    public static Dealership getDealerShip() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventorybackup.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            String[] dealerShipSplit = line.split(Pattern.quote("|"));
            String name = dealerShipSplit[0];
            String address = dealerShipSplit[1];
            String phoneNumber = dealerShipSplit[2];
            Dealership dealership = new Dealership(name, address, phoneNumber);

            while ((line = bufferedReader.readLine()) != null) {
                String[] vehicleSplit = line.split(Pattern.quote("|"));
                int vin = Integer.parseInt(vehicleSplit[0]);
                int year = Integer.parseInt(vehicleSplit[1]);
                String make = vehicleSplit[2];
                String model = vehicleSplit[3];
                String vehicleType = vehicleSplit[4];
                String color = vehicleSplit[5];
                int odometer = Integer.parseInt(vehicleSplit[6]);
                BigDecimal price = new BigDecimal(vehicleSplit[7]);
                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(newVehicle);
            }

            bufferedReader.close();

            return dealership;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void saveDealerShip (Dealership dealership) {

    }

}
