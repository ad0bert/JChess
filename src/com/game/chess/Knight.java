package com.game.chess;

public class Knight extends Figure {
    public Knight(Player player) {
        super(player);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return this.player + String.valueOf(this.getClass().getSimpleName().charAt(1)).toUpperCase();
    }

    @Override
    protected boolean validMove(Position from, Position to) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean move(Position from, Position to, Tile[][] board) {
        // TODO Auto-generated method stub
        return false;
    }

}
