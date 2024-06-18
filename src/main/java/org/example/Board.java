package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }
        }
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

    public char checkGameStatus() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != '-' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return cells[i][0];
            }
            if (cells[0][i] != '-' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return cells[0][i];
            }
        }

        // Check diagonals
        if (cells[0][0] != '-' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return cells[0][0];
        }
        if (cells[0][2] != '-' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return cells[0][2];
        }

        // Check for draw
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '-') {
                    return '-';
                }
            }
        }

        // If no winner and no empty cells, it's a draw
        return 'D';
    }
}