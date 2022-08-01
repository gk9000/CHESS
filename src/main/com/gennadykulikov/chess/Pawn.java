package com.gennadykulikov.chess;

public class Pawn extends Piece {

    public Pawn(String name, boolean isWhite, byte row, byte column) {
        super(name, isWhite, row, column);
    }

    byte direction = (byte) ( isWhite ? -1 : 1 );
    byte startingRow = (byte) ( isWhite ? 6 : 1 );

    // This overridden method is used only to check whether this. pawn may attack enemy king.
    // It is NOT used to calculate actual movements
    @Override
    boolean calculateMovement(byte destinationRow, byte destinationColumn){
        return  (destinationRow - this.row == direction) &&
                ( (destinationColumn == this.column+1) || (destinationColumn == this.column-1) );
    }

    static boolean calculatePawnMovement(Pawn pawn, byte destinationRow, byte destinationColumn) {
        if( (Board.board[destinationRow][destinationColumn] != null)
            && (Board.board[destinationRow][destinationColumn].isWhite==pawn.isWhite) ){
            System.out.println("Illegal move");
            return false;
        } else if( (Board.board[destinationRow][destinationColumn] != null)
                && (Board.board[destinationRow][destinationColumn].isWhite!=pawn.isWhite) ){
                pawn.moveAndTake(destinationRow,destinationColumn);
            return false;
        } else if(pawn.row==pawn.startingRow){
            if ( ( (destinationRow==pawn.row+2*pawn.direction) || (destinationRow==pawn.row+pawn.direction) )
                && (destinationColumn==pawn.column)
                && (JumpingOverAnotherPieceVerification.verifyNotJumpingOverMovingForwardOrBack(pawn,destinationRow))  ){
                Move.performMove(pawn, destinationRow,destinationColumn);
                return false;
            }
        } else if ( (destinationRow==pawn.row+pawn.direction) && (destinationColumn==pawn.column) ){
            Move.performMove(pawn, destinationRow,destinationColumn);
            return false;
        }
        System.out.println("Illegal move");
        return false;
    }

    public void moveAndTake(byte destinationRow, byte destinationColumn) {
        if ( (destinationRow - this.row == direction) &&
                ( (destinationColumn == this.column+1) || (destinationColumn == this.column-1) ) ) {
            Move.performMove(this, destinationRow,destinationColumn);
        } else {
            System.out.println("Illegal move");
        }
    }
}
