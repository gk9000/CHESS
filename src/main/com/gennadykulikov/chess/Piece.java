package com.gennadykulikov.chess;

import static com.gennadykulikov.chess.Conversion.convertColumn;
import static com.gennadykulikov.chess.Conversion.convertRow;

public abstract class Piece {
    String name;
    boolean isCaptured;
    boolean isWhite;
    byte row;
    byte column;

    public Piece(String name, boolean isCaptured, boolean isWhite, byte row, byte column) {
        this.name = name;
        this.isCaptured = isCaptured;
        this.isWhite = isWhite;
        this.row = row;
        this.column = column;
        Board.board[this.row][this.column] = this;
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
                calculateMovement(destinationRow,destinationColumn);
                return;
            }

            boolean okDestinationFieldAvailable =
                    verifyThatDestinationFieldIsAvailable(destinationRow,destinationColumn);

            boolean okMovement = (calculateMovement(destinationRow, destinationColumn));

            if (okMovement && okDestinationFieldAvailable) {
                if (Board.board[destinationRow][destinationColumn] != null) {
                    capturePiece(destinationRow, destinationColumn);
                }
                performMove(destinationRow,destinationColumn,this.row,this.column);
            } else {
                System.out.println("Illegal move");
            }
        }
    }

    abstract boolean calculateMovement(byte destinationRow, byte destinationColumn);

    public void performMove(byte destinationRow, byte destinationColumn, byte thisRow, byte thisColumn){
        Board.board[destinationRow][destinationColumn] = this;
        Board.board[thisRow][thisColumn] = null;
        this.row = destinationRow;
        this.column = destinationColumn;
    }

    public void capturePiece(byte row, byte column){
        Board.board[row][column].isCaptured = true;
        Board.takenPieces[Board.takenPiecesCounter] = Board.board[row][column];
        Board.takenPiecesCounter++;
    }

    public boolean verifyThatDestinationFieldIsAvailable(byte destinationRow,byte destinationColumn){
        if ((Board.board[destinationRow][destinationColumn] == null) ||
                (Board.board[destinationRow][destinationColumn].isWhite != this.isWhite)) {
            return true;
        }
        return false;
    }

    public boolean verifyNotJumpingOverMovingAside(byte destinationColumn){
        for(int i = this.column+1; i < destinationColumn; i++ ) {
            if(Board.board[this.row][i] != null){
                return false;
            }
        }
        for(int i = this.column-1; i > destinationColumn; i-- ) {
            if(Board.board[this.row][i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean verifyNotJumpingOverMovingForvardOrBack(byte destinationRow){
        for(int i = this.row+1; i < destinationRow; i++ ) {
            if(Board.board[i][this.column] != null){
                return false;
            }
        }
        for(int i = this.row-1; i > destinationRow; i-- ) {
            if(Board.board[i][this.column] != null){
                return false;
            }
        }
        return true;
    }

    public boolean verifyNotJumpingOverMovingAcross(byte destinationRow, byte destinationColumn){
        for(int a=this.row+1, b=this.column+1; a<destinationRow && b<destinationColumn; a++,b++ ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=this.row+1, b=this.column-1; a<destinationRow && b>destinationColumn; a++,b-- ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=this.row-1, b=this.column+1; a>destinationRow && b<destinationColumn; a--,b++ ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=this.row-1, b=this.column-1; a>destinationRow && b>destinationColumn; a--,b-- ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" +
                "isTaken=" + isCaptured +
                ", isWhite=" + isWhite +
                ", row=" + row +
                ", column=" + column +
                ')';
    }
}
