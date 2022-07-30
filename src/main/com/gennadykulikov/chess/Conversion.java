package com.gennadykulikov.chess;

import java.util.Optional;

/*
*  The methods receive description of a field (for example, a3 or g6) and returns
* byte (from 0 to 7 inclusive) that corresponds to the index of that row or column
*/
public class Conversion {

    static byte convertRow(String coordinates) {
        return (byte) (56 - coordinates.charAt(1));
    }

    static byte convertColumn(String coordinates) {
        return (byte) (coordinates.charAt(0) - 97);
    }
}
