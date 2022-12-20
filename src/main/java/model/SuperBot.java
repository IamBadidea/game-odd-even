package model;

import java.util.Random;

public class SuperBot extends Bot{

    private String winMove;
    private int winPercentage;

    public SuperBot(String name, int winPercentage) {
        super(name);
        this.winPercentage = winPercentage;
    }

    public String getMove(String winMove, String[] moves) {
        Random random = new Random();
        int percentage = random.nextInt(100);
        if (winPercentage > percentage) {
            return winMove;
        }
        for (String move : moves) {
            if (!move.equals(winMove)) {
                return move;
            }
        }
        throw new IllegalArgumentException("Некорректный список ходов!");
    }
}
