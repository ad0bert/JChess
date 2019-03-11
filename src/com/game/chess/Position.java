package com.game.chess;

public class Position {
    private int x, y;

    public Position(int i, char j) {
        this.x = 8 - i;
        this.y = j - 97;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
