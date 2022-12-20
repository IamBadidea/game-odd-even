package controller;

import model.Bot;
import model.Player;
import model.SuperBot;
import view.IView;
import view.ViewConsole;

public class MainSuperBot {
    public static void main(String[] args) {
        Player player1 = new Player("Petr");
        Player player2 = new SuperBot("Katya", 10);
        IView view = new ViewConsole();
        GameController gameController = new GameController(player1, player2, view);
        gameController.start();
    }
}
