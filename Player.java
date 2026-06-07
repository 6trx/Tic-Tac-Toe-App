package com.exam.tictactoe;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private final PlayerSymbol symbol;

    public Player(String name, PlayerSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() { return name; }
    public PlayerSymbol getSymbol() { return symbol; }

    // Overloaded methods
    public void makeMove(TicTacToe game, int row, int col) throws InvalidMoveException {
        game.makeMove(row, col, symbol.name().charAt(0));
    }

    public void makeMove(TicTacToe game, String input) throws InvalidMoveException {
        String[] parts = input.split(",");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        makeMove(game, row, col);
    }
}
