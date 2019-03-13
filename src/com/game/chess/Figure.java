package com.game.chess;

public abstract class Figure {
    protected final Player player;

    public Figure(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return this.player + String.valueOf(this.getClass().getSimpleName().charAt(0));
    }

    protected abstract boolean validMove(Position from, Position to);

    public abstract boolean move(Position from, Position to, Tile[][] board);

}
