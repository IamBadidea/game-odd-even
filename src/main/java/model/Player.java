package model;

public class Player {
    private String name;
    private String move;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
