package controller;

import model.Bot;
import model.Player;
import model.SuperBot;
import view.IView;

import java.util.Random;

public class GameController {

    private final static String MOVE0 = "Ч";
    private final static String MOVE1 = "Н";

    Player player1;

    Player player2;
    Player currentPlayer;
    IView view;

    public GameController(Player player1, Player player2, IView view) {
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
        this.currentPlayer = player1;
    }

    public void start() {
        String winResult = genWinResult();
        while (true) {
            String message = String.format("%s, введите Ваш ход (%s - чёт, %s - нечет):", currentPlayer.getName(), MOVE0, MOVE1);
            view.output(message);
            String move = getMove(currentPlayer, winResult);
            if (!isCorrectMove(move)) {
                view.output("Ошибка ввода!");
                continue;
            }
            currentPlayer.setMove(move);
            if (currentPlayer == player2) {
                showWinResult(winResult);
                Player playerWinner = winner(winResult);
                showGameResult(playerWinner);
                break;
            }
            currentPlayer = player2;
        }

    }

    private String getMove(Player player, String winMove) {
        if (player.getClass() == Player.class) {
            return view.input().toUpperCase();
        }
        if (player.getClass() == SuperBot.class) {
            SuperBot superBot = (SuperBot) player;
            String moveBot = superBot.getMove(winMove, new String[]{MOVE0, MOVE1});
            view.output(moveBot);
            return moveBot;
        }

        Bot bot = (Bot) player;
        String moveBot = bot.getMove(new String[]{MOVE0, MOVE1});
        view.output(moveBot);
        return moveBot;
    }

    private boolean isCorrectMove(String move) {
        return move.equals(MOVE0) || move.equals(MOVE1);
    }

    private static String genWinResult() {
        Random random = new Random();
        int result = random.nextInt(2);
        return result == 0 ? MOVE0 : MOVE1;
    }

    private void showWinResult(String winResult) {
        view.output("Выигрышный номер = " + winResult);
    }

    private void showGameResult(Player playerWinner) {
        if (playerWinner == null) {
            view.output("Увы, ничья!");
        } else {
            view.output("Выиграл игрок " + playerWinner.getName());
        }
    }

    private Player winner(String winMove) {
        if (player1.getMove().equals(player2.getMove())) {
            return null;
        } else if (player1.getMove().equals(winMove)) {
            return player1;
        }
        return player2;
    }
}
