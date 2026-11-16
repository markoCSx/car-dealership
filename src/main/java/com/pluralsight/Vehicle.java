package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private BigDecimal price;

    public Vehicle (int vin, int year, String make, String model, String vehicleType, String color, int odometer,BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String displayString () {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%s", this.vin, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);
    }

    public void display () {
        System.out.printf("Vin: %d Year:%d Make: %s Model: %s Type: %s Color %s Mileage: %d Price: %s\n", this.vin, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
