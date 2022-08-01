package com.gennadykulikov.chess;

import static com.gennadykulikov.chess.Conversion.convertColumn;
import static com.gennadykulikov.chess.Conversion.convertRow;

public abstract class Piece {
    String name;
    boolean isWhite;
    byte row;
    byte column;

    public Piece(String name, boolean isWhite, byte row, byte column) {
        this.name = name;
        this.isWhite = isWhite;
        this.row = row;
        this.column = column;
        Board.board[this.row][this.column] = this;
        Board.activePieces.add(this);
    }

    void move(String destinationField) {
        boolean okInputStringValidation = false;
        okInputStringValidation = InputValitation.validateCoordinates(destinationField);

        if (okInputStringValidation) {
            byte destinationRow = convertRow(destinationField);
            byte destinationColumn = convertColumn(destinationField);

            // make sure that a king is not captured
            if ( (Board.board[destinationRow][destinationColumn] != null)
                && (Board.board[destinationRow][destinationColumn].getClass().equals(King.class)) ){
                System.out.println("Illegal move");
                return;
            }

            // if this. is a pawn, switching to pawn-unique logics and after that breaking execution of current method
            if (this.getClass().equals(Pawn.class)){
                Pawn.calculatePawnMovement((Pawn)this, destinationRow,destinationColumn);
                return;
            }

            boolean okDestinationFieldAvailable =
                    verifyThatDestinationFieldIsAvailable(destinationRow,destinationColumn);

            boolean okMovement = (calculateMovement(destinationRow, destinationColumn));

            if (okMovement && okDestinationFieldAvailable) {
                Move.performMove(this,destinationRow,destinationColumn);
            } else {
                System.out.println("Illegal move");
            }
        }
    }

    abstract boolean calculateMovement(byte destinationRow, byte destinationColumn);

    ////                    REMEMBER TO UPDATE SAME IN PAWN CLASS AND DO VERIFICATION OF ENEMY KING (ALSO IN PAWN)


    public boolean verifyThatDestinationFieldIsAvailable(byte destinationRow,byte destinationColumn){
        if ((Board.board[destinationRow][destinationColumn] == null) ||
                (Board.board[destinationRow][destinationColumn].isWhite != this.isWhite)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (" +
                ", isWhite=" + isWhite +
                ", row=" + row +
                ", column=" + column +
                ')';
    }
}
