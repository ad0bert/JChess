package com.game.chess;

public class Board {
    private int FIELD_SIZE = 8;

    private Player white, black, currPlayer;

    private Tile[][] field = new Tile[this.FIELD_SIZE][this.FIELD_SIZE];

    public Board() {
        this.currPlayer = this.white = new Player("White");
        this.black = new Player("Black");
        this.initField();
    }

    public void resetBoard() {
        this.currPlayer = this.white;
        this.initField();
    }

    private void initField() {
        for (int i = 0; i < this.FIELD_SIZE; ++i) {
            this.field[i] = new Tile[this.FIELD_SIZE];
            for (int j = 0; j < this.FIELD_SIZE; ++j) {
                Player initPlayer = null;
                if (i < 2) {
                    initPlayer = this.black;
                } else if (i > 5) {
                    initPlayer = this.white;
                }
                this.field[i][j] = new Tile(i, j, initPlayer);
            }
        }
    }

    public boolean isRunning() {
        return true;
    }

    public void move(Position from, Position to) {
        if ((from.getX() > this.FIELD_SIZE) || (to.getX() > this.FIELD_SIZE) || (from.getY() > this.FIELD_SIZE)
                || (to.getY() > this.FIELD_SIZE) || (from.getX() < 0) || (to.getX() < 0) || (from.getY() < 0)
                || (to.getY() < 0)) {
            System.out.println("Input out of Range! Try Again.");
            return;
        }

        Tile curr = this.field[from.getX()][from.getY()];
        Tile next = this.field[to.getX()][to.getY()];

        if (!curr.hasFigure()) {
            System.out.println("No figure selected! Try Again.");
            return;
        }
        if (!curr.getFigure().getPlayer().equals(this.currPlayer)) {
            System.out.println(this.currPlayer + " has to move!");
            return;
        }
        if (next.hasFigure() && next.getFigure().getPlayer().equals(this.currPlayer)) {
            System.out.println("You cannot capture your own figures");
            return;
        }

        Figure toMove = curr.getFigure();
        Figure toRemove = next.getFigure();

        if (!toMove.move(from, to, this.field)) {
            return;
        }
        curr.setFigure(null);
        next.setFigure(toMove);

        if (isCheck()) {
            curr.setFigure(toMove);
            next.setFigure(toRemove);
            System.out.println("King is in Check after this move!");
            return;
        }

        if (this.currPlayer.equals(this.white)) {
            this.currPlayer = this.black;
        } else {
            this.currPlayer = this.white;
        }
    }

    private boolean isCheck() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" |a |b |c |d |e |f |g |h |\n");
        sb.append("--------------------------\n");
        for (int i = 0; i < this.FIELD_SIZE; ++i) {
            sb.append(this.FIELD_SIZE - i).append("|");
            for (int j = 0; j < this.FIELD_SIZE; ++j) {
                sb.append(this.field[i][j]).append("|");
            }
            sb.append(this.FIELD_SIZE - i).append("\n");
            sb.append("--------------------------\n");
        }
        sb.append(" |a |b |c |d |e |f |g |h |\n");
        sb.append(this.currPlayer).append(": ");
        return sb.toString();
    }

}
