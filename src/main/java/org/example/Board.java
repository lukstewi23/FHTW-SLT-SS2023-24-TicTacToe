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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cells[i][j] == '\0' ? ' ' : cells[i][j]);
                if (j < 2) {
                    sb.append('|');
                }
            }
            if (i < 2) {
                sb.append('\n');
                sb.append("-----");
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}