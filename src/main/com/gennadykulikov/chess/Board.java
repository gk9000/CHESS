package com.gennadykulikov.chess;

import java.util.ArrayList;

public class Board {
    private static Board b;
    static Piece[][] board = new Piece[8][8];
    static ArrayList<Piece> activePieces = new ArrayList<Piece>();
    static ArrayList<Piece> capturedPieces = new ArrayList<Piece>();

    private Board(){}

    public static Board getBoard(){
        if (b==null) {
            b = new Board();
        }
        return b;
    }

    //     populating the board with pieces

    static  Piece whiteRook01 = new Rook("whiteRook01",true, (byte) 7, (byte) 0);
    static Piece whiteRook02 = new Rook("whiteRook02",true, (byte) 7, (byte) 7);
    static Piece whiteKnight01 = new Knight("whiteKnight01",true,  (byte) 7, (byte) 1);
    static Piece whiteKnight02 = new Knight("whiteKnight02",true,  (byte) 7, (byte) 6);
    static Piece whiteBishop01 = new Bishop("whiteBishop01",true,  (byte) 7, (byte) 2);
    static Piece whiteBishop02 = new Bishop("whiteBishop02",true,  (byte) 7, (byte) 5);
    static Piece whiteQueen = new Queen("whiteQueen",true,  (byte) 7, (byte) 4);
    static Piece whiteKing = new King("whiteKing",true,  (byte) 7, (byte) 3);

    static Piece whitePawn01 = new Pawn("whitePawn01",true,  (byte) 6, (byte) 0);
    static Piece whitePawn02 = new Pawn("whitePawn02",true,  (byte) 6, (byte) 1);
    static Piece whitePawn03 = new Pawn("whitePawn03",true,  (byte) 6, (byte) 2);
    static Piece whitePawn04 = new Pawn("whitePawn04",true,  (byte) 6, (byte) 3);
    static Piece whitePawn05 = new Pawn("whitePawn05",true,  (byte) 6, (byte) 4);
    static Piece whitePawn06 = new Pawn("whitePawn06",true,  (byte) 6, (byte) 5);
    static Piece whitePawn07 = new Pawn("whitePawn07",true,  (byte) 6, (byte) 6);
    static Piece whitePawn08 = new Pawn("whitePawn08",true,  (byte) 6, (byte) 7);

    static Piece blackRook01 = new Rook("blackRook01",false,  (byte) 0, (byte) 0);
    static Piece blackRook02 = new Rook("blackRook02",false,  (byte) 0, (byte) 7);
    static Piece blackKnight01 = new Knight("blackKnight01",false,  (byte) 0, (byte) 1);
    static Piece blackKnight02 = new Knight("blackKnight02",false,  (byte) 0, (byte) 6);
    static Piece blackBishop01 = new Bishop("blackBishop01",false,  (byte) 0, (byte) 2);
    static Piece blackBishop02 = new Bishop("blackBishop02",false,  (byte) 0, (byte) 5);
    static Piece blackQueen = new Queen("blackQueen",false,  (byte) 0, (byte) 4);
    static Piece blackKing = new King("blackKing",false,  (byte) 4, (byte) 7);

    static Piece blackPawn01 = new Pawn("blackPawn01",false,  (byte) 1, (byte) 0);
    static Piece blackPawn02 = new Pawn("blackPawn02",false,  (byte) 1, (byte) 1);
    static Piece blackPawn03 = new Pawn("blackPawn03",false,  (byte) 1, (byte) 2);
    static Piece blackPawn04 = new Pawn("blackPawn04",false,  (byte) 1, (byte) 3);
    static Piece blackPawn05 = new Pawn("blackPawn05",false,  (byte) 1, (byte) 4);
    static Piece blackPawn06 = new Pawn("blackPawn06",false,  (byte) 1, (byte) 5);
    static Piece blackPawn07 = new Pawn("blackPawn07",false,  (byte) 1, (byte) 6);
    static Piece blackPawn08 = new Pawn("blackPawn08",false, (byte) 1, (byte) 7);
}
