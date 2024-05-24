package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board.isCellEmpty(i, 0) && board.isCellEmpty(i, 1) && board.isCellEmpty(i, 2)) {
                return true;
            }
            if (board.isCellEmpty(0, i) && board.isCellEmpty(1, i) && board.isCellEmpty(2, i)) {
                return true;
            }
        }
        if (board.isCellEmpty(0, 0) && board.isCellEmpty(1, 1) && board.isCellEmpty(2, 2)) {
            return true;
        }
        if (board.isCellEmpty(0, 2) && board.isCellEmpty(1, 1) && board.isCellEmpty(2, 0)) {
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}