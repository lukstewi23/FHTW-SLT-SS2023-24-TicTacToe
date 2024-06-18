package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int row = -1;
            int col = -1;
            while (true) {
                System.out.println("Enter row and column (1-3, separated by a space): ");
                try {
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Invalid input. Enter row and column (1-3, separated by a space): ");
                        continue;
                    }
                    if (!game.getBoard().isCellEmpty(row, col)) {
                        System.out.println("Cell is not empty. Enter row and column (1-3, separated by a space): ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter row and column (1-3, separated by a space): ");
                    scanner.next(); // discard invalid input
                }
            }
            game.getBoard().place(row, col, game.getCurrentPlayer().getMarker());
            char status = game.getBoard().checkGameStatus();
            if (status == 'X' || status == 'O') {
                System.out.println("Player " + status + " wins!");
                break;
            } else if (status == 'D') {
                System.out.println("The game is a draw!");
                break;
            }
            game.displayGameState();
            game.switchCurrentPlayer();
        }
    }
}