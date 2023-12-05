package com.circleandcross;

import java.util.Scanner;

public class Game {
    // Deklaracja zmiennych
    private Board board;
    private Player playerX;
    private Player playerO;

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isPlayerXTrue = true;
        boolean gameOver = false;

        while (!gameOver) {
            board.printBoards();
            System.out.println("Player " + (isPlayerXTrue ? 'X': 'O'));

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            boolean moveMade = board.makeMove(row, col, isPlayerXTrue ? playerX.getToken() : playerO.getToken());

            if (moveMade) {
                gameOver = board.isWinner(isPlayerXTrue ? playerX.getToken() : playerO.getToken());
                if (gameOver) {
                    System.out.println("Player " + (isPlayerXTrue ? 'X' : 'O') + " wins!");
                } else {
                    // Zmiana gracza, jeśli ruch był poprawny i nie zakończył gry
                    isPlayerXTrue = !isPlayerXTrue;
                }
            } else {
                System.out.println("Niepoprawny ruch, spróbuj jeszcze raz!");
            }
        }
        if (!gameOver) {
            System.out.println("Remis!");
        }
        board.printBoards();
    }
}
