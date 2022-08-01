package com.gennadykulikov.chess;

public class KingsUnderAttackVerification {


    public static boolean checkWhetherOwnKingIsUnderAttack(boolean isWhite){
        boolean result = false;
        for(Piece p : Board.activePieces){
            if(p.isWhite!=isWhite){
                result = p.calculateMovement( (isWhite ? Board.whiteKing : Board.blackKing).row,  (isWhite ? Board.whiteKing : Board.blackKing).column );
                if(result){
                    System.out.println("Your king is under attack, the move is cancelled");
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkWhetherEnemyKingIsUnderAttack(boolean isWhite){
        boolean result;
        for(Piece p : Board.activePieces){
            if(p.isWhite==isWhite){
                result = p.calculateMovement( (isWhite ? Board.blackKing : Board.whiteKing).row,  (isWhite ? Board.blackKing : Board.whiteKing).column );
                if(result){
                    System.out.printf("Attention! %s king is under attack!%n", (isWhite ? "Black" : "White"));
                return;
                }
            }
        }

    }

}
