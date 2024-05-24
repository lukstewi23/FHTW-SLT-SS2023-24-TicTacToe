package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        char marker = 'X';

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
                    if (!board.isCellEmpty(row, col)) {
                        System.out.println("Cell is not empty. Enter row and column (1-3, separated by a space): ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter row and column (1-3, separated by a space): ");
                    scanner.next(); // discard invalid input
                }
            }
            board.place(row, col, marker);
            board.print();
        }
    }
}