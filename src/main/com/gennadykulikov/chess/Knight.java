package com.gennadykulikov.chess;

public class Knight extends Piece{
    public Knight(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);
    }

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        if ((destinationRow==this.row+2) && ((destinationColumn==this.column-1) || (destinationColumn==this.column+1))){
            return true;
        }
        if ((destinationRow==this.row-2) && ((destinationColumn==this.column-1) || (destinationColumn==this.column+1))){
            return true;
        }
        if ((destinationColumn==this.column+2) && ((destinationRow==this.row-1) || (destinationRow==this.row+1))){
            return true;
        }
        if ((destinationColumn==this.column-2) && ((destinationRow==this.row-1) || (destinationRow==this.row+1))){
            return true;
        }
        return false;
    }
}
