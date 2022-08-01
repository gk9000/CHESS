package com.gennadykulikov.chess;

public class Bishop extends Piece{
    public Bishop(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);
    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        boolean result1 = ( (destinationRow - this.row == destinationColumn - this.column) ||
        (destinationRow + destinationColumn == this.row + this.column) );
        boolean result2 = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingAcross(this,destinationRow,destinationColumn);
        return result1 && result2;
    }
}
