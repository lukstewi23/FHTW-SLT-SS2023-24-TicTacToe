package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
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
            game.getBoard().print(); // print the board state after each move
            char status = game.getBoard().checkGameStatus();
            if (status == 'X' || status == 'O') {
                System.out.println("Player " + status + " wins!");
                game = askForNewGame(scanner);
                if (game == null) {
                    break;
                }
            } else if (status == 'D') {
                System.out.println("The game is a draw!");
                game = askForNewGame(scanner);
                if (game == null) {
                    break;
                }
            } else {
                game.displayGameState();
                game.switchCurrentPlayer();
            }
        }
    }

    private static TicTacToe askForNewGame(Scanner scanner) {
        System.out.println("Do you want to start a new game? (yes/no)");
        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("yes")) {
                return new TicTacToe();
            } else if (input.equals("no")) {
                return null;
            } else {
                System.out.println("Invalid input. Do you want to start a new game? (yes/no)");
            }
        }
    }
}