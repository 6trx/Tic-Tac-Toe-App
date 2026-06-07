package com.exam.tictactoe;

public class MoveTimer extends Thread {
    public void run() {
        try {
            Thread.sleep(1000); // pause before computer move
            System.out.println("Computer is thinking...");
        } catch (InterruptedException e) {
            System.out.println("MoveTimer interrupted: " + e.getMessage());
        }
    }
}
