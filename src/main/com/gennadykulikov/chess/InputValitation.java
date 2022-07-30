package com.gennadykulikov.chess;

public class InputValitation {
    public static boolean validateCoordinates(String field) {
        boolean result = false;
        if (field.matches("[a-h][1-8]")) {
            result = true;
        } else {
            System.out.println("Please provide valid destination field coordinates");
        }
        return result;
    }
}
