package com.gennadykulikov.chess;

public class Rook extends Piece {
    public Rook(String name, boolean isCaptured, boolean isWhite, byte row, byte column) {
        super(name,isCaptured, isWhite, row, column);

    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn){
        boolean result1 = destinationRow == this.row || destinationColumn == this.column;
        boolean result2  = verifyNotJumpingOverMovingAside(destinationColumn);
        boolean result3  = verifyNotJumpingOverMovingForvardOrBack(destinationRow);
        return result1 && result2 & result3;
    }
}
