package com.game.chess;

public class Player {
    private String name;

    public Player(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.equals("White") ? "W" : "B";
    }
}
