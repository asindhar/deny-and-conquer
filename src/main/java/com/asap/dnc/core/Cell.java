package com.asap.dnc.core;

/**
 * Abstract representation of a cell within a game board. Server/client side implementations must
 * implement the method to fill a specified pixel as belonging to a specified player.
 */
public abstract class Cell {
    private int[][] pixels;
    private int nRows;
    private int nCols;

    private int pixelsFilled = 0; // number of pixels filled by the player with access
    private int ctrlReq; // number of pixels needed to be filled for ownership
    private int owner = -1; // set once ctrlReq has been met

    // Subclasses should implement a factory method making use of this
    protected Cell(int nRows, int nCols, int ctrlReq) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.ctrlReq = ctrlReq;
        pixels = new int[nRows][nCols];
    }

    // implement in subclass
    public abstract boolean fillCell(int rowIdx, int colIdx, int player);

    public void clearCell() {
        this.owner = -1;
    }

    public boolean isFull() {
        return pixelsFilled == 100;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}