package com.gennadykulikov.chess;

public class Queen extends Piece {
    public Queen(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);
    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        boolean result1 = ( (destinationRow - this.row == destinationColumn - this.column) ||
                (destinationRow + destinationColumn == this.row + this.column) ||
                (destinationRow == this.row || destinationColumn == this.column) );
        boolean result2 = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingAside(this,destinationColumn);
        boolean result3 = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingForwardOrBack(this,destinationRow);
        boolean result4 = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingAcross(this,destinationRow,destinationColumn);
        return result1 && result2 && result3 && result4;
    }
}
