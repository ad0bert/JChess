package com.game.chess;

public final class FigureFactory {

    public static Figure createFigure(int i, int j, Player player) {
        if ((i == 1) || (i == 6)) {
            return new Pawn(player);
        }
        if ((j == 0) || (j == 7)) {
            return new Rook(player);
        }
        if ((j == 1) || (j == 6)) {
            return new Knight(player);
        }
        if ((j == 2) || (j == 5)) {
            return new Bishop(player);
        }
        if (j == 3) {
            return new Queen(player);
        }
        if (j == 4) {
            return new King(player);
        }
        return null;
    }

}
