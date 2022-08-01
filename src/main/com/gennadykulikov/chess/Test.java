package com.gennadykulikov.chess;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Board.getBoard();

        System.out.println(Board.blackPawn06);
        Board.blackPawn06.move("f6");
        System.out.println(Board.blackPawn06);
        System.out.println();

        System.out.println(Board.whitePawn02);
        Board.whitePawn02.move("b4");
        System.out.println(Board.whitePawn02);
        System.out.println();

        System.out.println(Board.whitePawn03);
        Board.whitePawn03.move("c4");
        System.out.println(Board.whitePawn03);
        System.out.println();

        System.out.println(Board.blackKing);
        Board.blackKing.move("h3");
        System.out.println(Board.blackKing);
        System.out.println();

        System.out.println(Board.blackPawn01);
        Board.blackPawn01.move("a6");
        System.out.println(Board.blackPawn01);
        System.out.println();
//
//        System.out.println(Board.blackPawn01);
//        Board.blackPawn01.move("a5");
//        System.out.println(Board.blackPawn01);
//        System.out.println();

//        System.out.println(Board.blackRook02);
//        Board.blackRook02.move("b3");
//        System.out.println(Board.blackRook02);
//        System.out.println();

        System.out.println(Board.whitePawn04);
        Board.whitePawn04.move("d4");
        System.out.println(Board.whitePawn04);
        System.out.println();

        System.out.println(Board.capturedPieces);


    }

}
