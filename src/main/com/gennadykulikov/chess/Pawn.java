package com.gennadykulikov.chess;

public class Pawn extends Piece {

    public Pawn(String name, boolean isCaptured, boolean isWhite, byte row, byte column) {
        super(name, isCaptured, isWhite, row, column);
    }

    byte direction = (byte) ( isWhite ? -1 : 1 );
    byte startingRow = (byte) ( isWhite ? 6 : 1 );

    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn) {
        if( (Board.board[destinationRow][destinationColumn] != null)
            && (Board.board[destinationRow][destinationColumn].isWhite==this.isWhite) ){
            return false;
        } else if( (Board.board[destinationRow][destinationColumn] != null)
                && (Board.board[destinationRow][destinationColumn].isWhite!=this.isWhite) ){
                   moveAndTake(destinationRow,destinationColumn);
            return false;
        } else if(this.row==startingRow){
            if ( ( (destinationRow==this.row+2*direction) || (destinationRow==this.row+direction) )
                && (destinationColumn==this.column)
                && (verifyNotJumpingOverMovingForvardOrBack(destinationRow))  ){
                performMove(destinationRow,destinationColumn,this.row,this.column);
                return false;
            }
        } else if ( (destinationRow==this.row+direction) && (destinationColumn==this.column) ){
            performMove(destinationRow,destinationColumn,this.row,this.column);
            return false;
        }
        System.out.println("Illegal move");
        return false;
    }

    public void moveAndTake(byte destinationRow, byte destinationColumn) {
        if ( (destinationRow - this.row == direction) &&
                ( (destinationColumn == this.column+1) || (destinationColumn == this.column-1) ) ) {
            capturePiece(destinationRow, destinationColumn);
            performMove(destinationRow,destinationColumn,this.row,this.column);
        } else {
            System.out.println("Illegal move");
        }
    }
}
