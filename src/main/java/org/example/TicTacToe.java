package org.example;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

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

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] board = this.getBoard().getCells();
        char marker = currentPlayer.getMarker();
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) {
                return true;
            }
            if (board[0][i] == marker && board[1][i] == marker && board[2][i] == marker) {
                return true;
            }
        }
        if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
            return true;
        }
        if (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker) {
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