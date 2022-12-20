package controller;

import model.Player;
import view.IView;
import view.ViewConsole;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Philip");
        Player player2 = new Player("Alexey");
        IView view = new ViewConsole();
        GameController gameController = new GameController(player1, player2, view);
        gameController.start();
    }
}
