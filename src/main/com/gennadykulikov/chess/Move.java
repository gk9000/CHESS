package com.gennadykulikov.chess;

public class Move {
    static boolean isWhite = true;

    public static void performMove(Piece piece,byte destinationRow, byte destinationColumn){

            if (isWhite == piece.isWhite) {
                boolean captureHappened = false;
                if (Board.board[destinationRow][destinationColumn] != null) {
                    Board.capturedPieces.add(Board.board[destinationRow][destinationColumn]);
                    Board.activePieces.remove(Board.board[destinationRow][destinationColumn]);
                    Board.board[destinationRow][destinationColumn] = null;
                    captureHappened = true;
                }
                Board.board[destinationRow][destinationColumn] = piece;
                Board.board[piece.row][piece.column] = null;
                LastMove lm = LastMove.getLastMove();
                lm.setPiece(piece);
                lm.setOriginRow(piece.row);
                lm.setOriginColumn(piece.column);
                lm.setDestinationRow(destinationRow);
                lm.setDestinationColumn(destinationColumn);
                lm.setCaptureHappened(captureHappened);
                piece.row = destinationRow;
                piece.column = destinationColumn;
                if (KingsUnderAttackVerification.checkWhetherOwnKingIsUnderAttack(piece.isWhite)) {
                    cancelMove(lm, piece);
                    return;
                }
                KingsUnderAttackVerification.checkWhetherEnemyKingIsUnderAttack(piece.isWhite);
                isWhite = ! isWhite;
            } else {
                System.out.println("Attempt of move out of turn - move cancelled");
                return;
            }
    }

    public static void cancelMove(LastMove lm, Piece piece){
        piece.row=lm.getOriginRow();
        piece.column=lm.getOriginColumn();
        Board.board[lm.getDestinationRow()][lm.getDestinationColumn()] = null;
        if(lm.getCaptureHappened()){
            Board.board[lm.getDestinationRow()][lm.getDestinationColumn()] = Board.capturedPieces.get(Board.capturedPieces.size()-1);
            Board.activePieces.add( Board.capturedPieces.get(Board.capturedPieces.size()-1) );
            Board.capturedPieces.remove(Board.capturedPieces.size()-1);
        }
    }
}
