package controller;

import model.Bot;
import model.Player;
import view.IView;
import view.ViewConsole;

public class Main2Bot {
    public static void main(String[] args) {
        Player player1 = new Bot("Petr");
        Player player2 = new Bot("Katya");
        IView view = new ViewConsole();
        GameController gameController = new GameController(player1, player2, view);
        gameController.start();
    }
}
