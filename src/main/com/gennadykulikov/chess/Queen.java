package com.gennadykulikov.chess;

public class Queen extends Piece {
    public Queen(String name, boolean isCaptured, boolean isWhite, byte row, byte column) {
        super(name, isCaptured, isWhite, row, column);
    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        boolean result1 = ( (destinationRow - this.row == destinationColumn - this.column) ||
                (destinationRow + destinationColumn == this.row + this.column) ||
                (destinationRow == this.row || destinationColumn == this.column) );
        boolean result2 = verifyNotJumpingOverMovingAside(destinationColumn);
        boolean result3 = verifyNotJumpingOverMovingForvardOrBack(destinationRow);
        boolean result4 = verifyNotJumpingOverMovingAcross(destinationRow,destinationColumn);
        return result1 && result2 && result3 && result4;
    }
}
