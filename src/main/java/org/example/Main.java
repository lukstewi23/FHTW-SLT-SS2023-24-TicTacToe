package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.start();
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

                if (game.hasWinner() || game.getBoard().isFull()) {
                    game.getBoard().print();
                    if (game.hasWinner()) {
                        System.out.println("Player " + game.getCurrentPlayer().getMarker() + " wins!");
                    } else {
                        System.out.println("It's a draw!");
                    }
                    break;
                }
                game.getBoard().print();
                System.out.println("Current player: " + game.getCurrentPlayer().getMarker());
                game.switchCurrentPlayer();
            }
            System.out.println("Play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}