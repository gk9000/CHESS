package com.gennadykulikov.chess;

public class Rook extends Piece {
    public Rook(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);

    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn){
        boolean result1 = destinationRow == this.row || destinationColumn == this.column;
        boolean result2  = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingAside(this,destinationColumn);
        boolean result3  = JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingForwardOrBack(this,destinationRow);
        return result1 && result2 & result3;
    }
}
