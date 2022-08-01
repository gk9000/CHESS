package com.gennadykulikov.chess;

public class King extends Piece {
    public King(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);
    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        if  ( ( (Math.abs(destinationRow - this.row) == 1 ) || (destinationRow - this.row == 0) )
                && ( (Math.abs(destinationColumn - this.column) == 1 ) || (destinationColumn - this.column == 0) ) ) {
            return true;
        }
        return false;
    }
}

