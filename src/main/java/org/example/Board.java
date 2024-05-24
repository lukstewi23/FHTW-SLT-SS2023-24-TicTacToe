package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == '-';
    }

    public void place(int row, int col, char marker) {
        cells[row][col] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (char[] row : cells) {
            java.util.Arrays.fill(row, '-');
        }
    }

    public void print() {
        for (char[] row : cells) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
