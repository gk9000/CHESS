package com.gennadykulikov.chess;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Board.getBoard();

//        System.out.println(Board.whiteBishop02);
//        Board.whiteBishop02.move("h3");
//        System.out.println(Board.whiteBishop02);
//        Board.whiteBishop02.move("f5");
//        System.out.println(Board.whiteBishop02);
//        Board.whitePawn05.move("e4");
//        System.out.println(Board.whitePawn05);
//        Board.whiteBishop02.move("d3");
//        System.out.println(Board.whiteBishop02);

        System.out.println(Board.whitePawn05);
        Board.whitePawn05.move("e4");
        System.out.println(Board.whitePawn05);



    }

}
