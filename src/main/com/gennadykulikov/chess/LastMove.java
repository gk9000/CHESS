package com.gennadykulikov.chess;

public class LastMove {
    private static LastMove lm;
    private Piece piece;
    private byte originRow;
    private byte originColumn;
    private byte destinationRow;
    private byte destinationColumn;
    private boolean captureHappened;


    private LastMove(){}

    public static LastMove getLastMove(){
        if (lm==null) {
            lm = new LastMove();
        }
        return lm;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean getCaptureHappened() {
        return captureHappened;
    }

    public void setCaptureHappened(boolean captureHappened) {
        this.captureHappened = captureHappened;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public byte getOriginRow() {
        return originRow;
    }

    public void setOriginRow(byte originRow) {
        this.originRow = originRow;
    }

    public byte getOriginColumn() {
        return originColumn;
    }

    public void setOriginColumn(byte originColumn) {
        this.originColumn = originColumn;
    }

    public byte getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(byte destinationRow) {
        this.destinationRow = destinationRow;
    }

    public byte getDestinationColumn() {
        return destinationColumn;
    }

    public void setDestinationColumn(byte destinationColumn) {
        this.destinationColumn = destinationColumn;
    }
}
