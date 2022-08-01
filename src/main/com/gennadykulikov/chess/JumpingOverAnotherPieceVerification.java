package com.gennadykulikov.chess;

public class JumpingOverAnotherPieceVerification {

    public static boolean verifyNotJumpingOverMovingAside(Piece piece, byte destinationColumn){
        for(int i = piece.column+1; i < destinationColumn; i++ ) {
            if(Board.board[piece.row][i] != null){
                return false;
            }
        }
        for(int i = piece.column-1; i > destinationColumn; i-- ) {
            if(Board.board[piece.row][i] != null){
                return false;
            }
        }
        return true;
    }

    public static boolean verifyNotJumpingOverMovingForwardOrBack(Piece piece, byte destinationRow){
        for(int i = piece.row+1; i < destinationRow; i++ ) {
            if(Board.board[i][piece.column] != null){
                return false;
            }
        }
        for(int i = piece.row-1; i > destinationRow; i-- ) {
            if(Board.board[i][piece.column] != null){
                return false;
            }
        }
        return true;
    }

    public static boolean verifyNotJumpingOverMovingAcross(Piece piece, byte destinationRow, byte destinationColumn){
        for(int a=piece.row+1, b=piece.column+1; a<destinationRow && b<destinationColumn; a++,b++ ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=piece.row+1, b=piece.column-1; a<destinationRow && b>destinationColumn; a++,b-- ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=piece.row-1, b=piece.column+1; a>destinationRow && b<destinationColumn; a--,b++ ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        for(int a=piece.row-1, b=piece.column-1; a>destinationRow && b>destinationColumn; a--,b-- ) {
            if(Board.board[a][b] != null){
                return false;
            }
        }
        return true;
    }





}
