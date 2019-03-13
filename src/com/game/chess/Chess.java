package com.game.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {

    public static void main(String[] args) throws IOException {
        Board board = new Board();
        while (true) {
            System.out.print(board);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            if (input.equals("RESET")) {
                board.resetBoard();
                continue;
            } else if (input.equals("END")) {
                break;
            }
            String[] parts = input.split(" ");
            Position from = new Position(Integer.parseInt(parts[0].substring(1, 2)), parts[0].charAt(0));
            Position to = new Position(Integer.parseInt(parts[1].substring(1, 2)), parts[1].charAt(0));
            board.move(from, to);
        }
    }

}
