package com.pluralsight;

import java.util.Scanner;

public class Util {
    public static Scanner userInput = new Scanner(System.in);

    private Util() {}

    public static String userPrompt () {
        String userText;
        userText = userInput.nextLine();
        return userText;
    }
}
