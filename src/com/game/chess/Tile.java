package com.game.chess;

import com.game.chess.Figure.Type;

public class Tile {
    private Figure figure = null;

    public Tile(int i, int j, Player player) {
        if (player != null) {
            this.figure = new Figure(Type.getTypeByPos(i, j), player);
        }
    }

    public boolean hasFigure() {
        return this.figure != null;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public void setFigure(final Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return this.figure == null ? "  " : this.figure.toString();
    }
}
