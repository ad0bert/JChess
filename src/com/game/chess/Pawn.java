package com.game.chess;

public class Pawn extends Figure {

    private boolean moved = false;

    public Pawn(Player player) {
        super(player);
    }

    @Override
    protected boolean validMove(Position from, Position to) {
        return false;
    }

    @Override
    public boolean move(Position from, Position to, Tile[][] board) {
        this.moved = true;
        return true;
    }

}
