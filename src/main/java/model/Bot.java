package model;

import java.util.Random;

public class Bot extends Player{
    public Bot(String name) {
        super(name);
    }

    public String getMove(String[] moves) {
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    @Override
    public String getName() {
        return super.getName() + "[BOT]";
    }
}
