package com.game.chess;

public class Figure {
    public enum Type {
        K, Q, R, B, N, P;

        public static Type getTypeByPos(int i, int j) {
            if ((i > 1) && (i < 6)) {
                throw new RuntimeException("Unable to initialize chess board!");
            }
            if ((i == 1) || (i == 6)) {
                return P;
            }
            if ((j == 0) || (j == 7)) {
                return R;
            }
            if ((j == 1) || (j == 6)) {
                return N;
            }
            if ((j == 2) || (j == 5)) {
                return B;
            }
            if (j == 3) {
                return Q;
            }
            if (j == 4) {
                return K;
            }
            throw new RuntimeException("Unable to initialize chess board!");
        }
    }

    private final Type type;
    private final Player player;

    public Figure(Type type, Player player) {
        this.type = type;
        this.player = player;
    }

    public Type getType() {
        return this.type;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return this.player + this.type.name();
    }

    public boolean inRange(Position from, Position to) {
        switch (this.type) {
        case K:
            return (Math.abs(from.getX() - to.getX()) < 2) && (Math.abs(from.getY() - to.getY()) < 2);
        case Q:
            return (from.getX() == to.getX()) || (from.getY() == to.getY());
        case R:
            return (from.getX() == to.getX()) || (from.getY() == to.getY());
        case B:
            return false;
        case N:
            return false;
        case P:
            if (this.player.toString().equals("W")) {

            } else {

            }
            return false;
        }
        return false;
    }
}
