package com.exam.tictactoe;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        game.readScores();

        Player p1 = new Player("Alice", PlayerSymbol.X);
        ComputerPlayer cpu = new ComputerPlayer("CPU", PlayerSymbol.O);

        System.out.println("Player 1 symbol: " + p1.getSymbol()); // demonstrates encapsulation

        // User input demo
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your move as row,col (e.g., 0,1): ");
        String userInput = sc.nextLine();

        try {
            p1.makeMove(game, userInput); // uses the String overload
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move: " + e.getMessage());
        }

        boolean keepPlaying = true;
        while (keepPlaying) {
            try {
                // Player 1 move
                p1.makeMove(game, 0, 0); // demo move

                // CPU move with timer
                MoveTimer timer = new MoveTimer();
                timer.start();   // runs the thread, pauses for 1 second
                cpu.makeMove(game, 1, 1); // demo move

                keepPlaying = false; // stop after demo
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move: " + e.getMessage());
            } finally {
                game.displayBoard();
            }
        }

        game.printMoves();
        game.saveWinner(p1.getName());
        game.serializePlayer(p1);
        game.jdbcDemo();
        game.requestCleanup();
    }
}
