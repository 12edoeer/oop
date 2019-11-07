package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.GetInput;
import hk.edu.polyu.comp.comp2021.jungle.model.JungleGame;

public class Application {

    public static void main(String[] args){
        JungleGame game = new JungleGame();
        System.out.println("The Jungle Game");
        System.out.print("start or load:");
        String input;

        while (true) {
            input = GetInput.Input();
            if (input.equals("start") || input.equals("Start") || input.equals("load") || input.equals("Load"))
                break;
            System.out.println("Wrong input, please input again");
        }// infinitive loop until user input start or load


        // the case of start
        if (input.equals("start") || input.equals("Start")) {
            game.getName();
            game.ChessInsert();
            game.PrintBoard();

        } else {
        }
        // start playing the game
    }
}
