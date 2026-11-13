package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class DealerShipManager {

    public static Dealership getDealerShip() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventorybackup.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            bufferedReader.close();

            String[] dealerShipSplit = line.split(Pattern.quote("|"));
            String name = dealerShipSplit[0];
            String address = dealerShipSplit[1];
            String phoneNumber = dealerShipSplit[2];

            Dealership dealership = new Dealership(name, address, phoneNumber);

            return dealership;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void saveDealerShip (Dealership dealership) {

    }

}
