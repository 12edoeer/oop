package controller;

import view.JungleView;

import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) {
        JungleGame game = new JungleGame();
        String input = "";

        JungleView.messageWithNextLine("The Jungle Game");
        JungleView.message("start or load:");

        do {
            try {
                input = GetInput.Input().toUpperCase();
            } catch (Exception e) {
                JungleView.messageWithNextLine("The input must be string.");
                input = "";
            }
        } while (InputChecker.startOrLoad(input));
        //loop until user input start or load


        // the case of start
        if (input.equals("START")) {
            game.getName();
            game.ChessInsert();
            game.boardPrint();

        } else {
        }
        // start playing the game

        boolean playerCon = true;
        while (true) {

            try {
                if (playerCon) {
                    JungleView.message(game.getPlayer1Name() + " turn, please input the chess that you want to move:");
                } else {
                    JungleView.message(game.getPlayer2Name() + " turn, please input the chess that you want to move:");
                }

                input = GetInput.Input().toUpperCase();
                char[] originalChess = input.toCharArray();
                originalChess[0] = input.charAt(0);
                int x = originalChess[0] - 65;
                int y = originalChess[1] - 49;
                if (x < 0 || x > 7 || y < 0 || y > 9) throw new Exception();

                JungleView.message("Target Location:");
                input = GetInput.Input().toUpperCase();
                char[] targetLocation = input.toCharArray();
                targetLocation[0] = input.charAt(0);

                int x1 = targetLocation[0] - 65;
                int y1 = targetLocation[1] - 49;
                if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 9) throw new Exception();

                if (playerCon) {
                    if (game.UserMove(x, y, x1, y1, 1))
                        playerCon = false;
                } else {
                    if (game.UserMove(x, y, x1, y1, 2))
                        playerCon = true;
                }

            game.boardPrint();
            } catch (Exception e) {
                JungleView.messageWithNextLine("Input does not in range A0 to G9");
            }
        }


    }
}
