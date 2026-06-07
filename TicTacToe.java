package com.exam.tictactoe;

import java.io.*;
import java.util.ArrayList;

public class TicTacToe {
    private final char[][] board = new char[3][3]; // 3x3 array
    private final ArrayList<String> moves = new ArrayList<>(); // collection of moves

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        for (char[] row : board) { // enhanced for loop
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int row, int col, char symbol) throws InvalidMoveException {
        if (board[row][col] != '-') {
            throw new InvalidMoveException("Cell already occupied!");
        }
        board[row][col] = symbol;
        moves.add(symbol + " at (" + row + "," + col + ")");
    }

    public void printMoves() {
        System.out.println("Moves played:");
        for (String move : moves) {
            System.out.println(move);
        }
    }

    // File I/O
    public void saveWinner(String winner) {
        try (FileWriter fw = new FileWriter("score.txt", true)) {
            fw.write(winner + "\n");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage()); }
    }

    public void readScores() {
        try (BufferedReader br = new BufferedReader(new FileReader("score.txt"))) {
            System.out.println("Previous winners:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No scores yet.");
        }
    }

    // Serialization demo
    public void serializePlayer(Player p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player.ser"))) {
            oos.writeObject(p);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage()); }
    }

    // JDBC demo
    public void jdbcDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mock load
            System.out.println("SELECT * FROM Scores;");
            throw new java.sql.SQLException("Mock SQL error");
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            System.out.println("JDBC Exception: " + e.getMessage());
        }
    }

    // Garbage collection
    public void requestCleanup() {
        System.gc();
        // JVM garbage collection reclaims memory from unused objects.
        // Options like -XX:+UseG1GC or -XX:+UseParallelGC tune performance.
    }
}
