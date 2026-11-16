package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    public Dealership (String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String dealershipString () {
        return String.format("%s|%s|%s", this.name, this.address, this.phoneNumber);
    }

    public ArrayList<Vehicle> getVehiclesByPrice (BigDecimal min, BigDecimal max) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getPrice().compareTo(min) >= 0 && currentVehicle.getPrice().compareTo(max) <= 0) {
                vehiclesByPrice.add(currentVehicle);
            }
        }
        return vehiclesByPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel (String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getMake().toLowerCase().equalsIgnoreCase(make) && currentVehicle.getModel().toLowerCase().equalsIgnoreCase(model)) {
                vehiclesByMakeModel.add(currentVehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear (int min, int max) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getYear() >= min && currentVehicle.getYear() <= max) {
                vehiclesByYear.add(currentVehicle);
            }
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor (String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getColor().toLowerCase().equalsIgnoreCase(color)) {
                vehiclesByColor.add(currentVehicle);
            }
        }
        return vehiclesByColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage (int min, int max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getOdometer() >= min && currentVehicle.getOdometer() <= max) {
                vehiclesByMileage.add(currentVehicle);
            }
        }
        return vehiclesByMileage;
    }

    public ArrayList<Vehicle> getVehiclesByType (String type) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle currentVehicle : inventory) {
            if (currentVehicle.getVehicleType().toLowerCase().equalsIgnoreCase(type)) {
                vehiclesByType.add(currentVehicle);
            }
        }
        return vehiclesByType;
    }

    public ArrayList<Vehicle> getAllVehicles () {
        return inventory;
    }

    public void addVehicle (Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle (Vehicle vehicle) {
        Integer foundIndex = null;
        int counter = -1;
        for(Vehicle v: this.inventory) {
            counter++;
            if(vehicle.getVin()  == v.getVin()) {
                foundIndex = counter;
                break;
            }
        }
        if(foundIndex != null) {
            inventory.remove(inventory.get(foundIndex));
        }
    }
}
