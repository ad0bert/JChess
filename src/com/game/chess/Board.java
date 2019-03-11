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

    private void initField() {
        for (int i = 0; i < this.FIELD_SIZE; ++i) {
            this.field[i] = new Tile[this.FIELD_SIZE];
            for (int j = 0; j < this.FIELD_SIZE; ++j) {
                Player currPlayer = null;
                if (i < 2) {
                    currPlayer = this.black;
                } else if (i > 5) {
                    currPlayer = this.white;
                }
                this.field[i][j] = new Tile(i, j, currPlayer);
            }
        }
    }

    public boolean isRunning() {
        return true;
    }

    public void move(Position from, Position to) {
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

        if (!toMove.inRange(from, to)) {
            System.out.println("Illegal move!");
            return;
        }

        curr.setFigure(null);
        next.setFigure(toMove);

        if (this.currPlayer.equals(this.white)) {
            this.currPlayer = this.black;
        } else {
            this.currPlayer = this.white;
        }
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
