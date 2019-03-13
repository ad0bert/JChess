package com.game.chess;

public class Rook extends Figure {

    private boolean moved = false;

    public Rook(Player player) {
        super(player);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean validMove(Position from, Position to) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean move(Position from, Position to, Tile[][] board) {
        this.moved = true;
        return false;
    }

}
