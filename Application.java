package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.JungleGame;

import java.util.InputMismatchException;

/**
 *
 */
public class Application {
    private static String input;
    public static boolean run = true;
    public static int moveCount = 1;
    public static void main(String[] args){
        JungleGame game = new JungleGame();
        // start playing the game
        startInput(game);
        getUserInput(game);
    }

    public static void startInput(JungleGame game){

        System.out.println("The Jungle Game");
        System.out.print("start or load:");



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

        }
    }
    public static void getUserInput(JungleGame game){
        while (run) {
            try {
                if(moveCount%2==1) {
                    System.out.println("Player one please input the chess that you want to move:");
                }else{
                    System.out.println("Player two please input the chess that you want to move:");
                }
                input = GetInput.Input();
                char originalChess[] = input.toCharArray();
                originalChess[0] = input.charAt(0);
                int x = originalChess[0] - 65;
                int y = originalChess[1] - 49;

                    if (x < 0 || x > 7 || y < 0 || y > 9) throw new Exception("Input does not in range A0 to G9");

                    System.out.println(x + " " + y);
                    System.out.println("Target Location:");
                    input = GetInput.Input().toUpperCase();
                    char targetLocation[] = input.toCharArray();
                    targetLocation[0] = input.charAt(0);

                    int x1 = targetLocation[0] - 65;
                    int y1 = targetLocation[1] - 49;
                    if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 9) throw new Exception("Input does not in range A0 to G9");
                    System.out.println(x1 + " " + y1);
                if(game.getPlayerjungleBoard(x,y)==0){
                    System.out.println("There is no Chess");
                }
                else if(game.getPlayerjungleBoard(x,y)!=moveCount){
                    System.out.println("Can't move other player chess");
                }
                else {
                    game.UserMove(x, y, x1, y1);
                    game.PrintBoard();

                    if(moveCount==2)moveCount=0;
                    moveCount++;
                    System.out.println(moveCount);
                }
            } catch (Exception e) {
                game.PrintBoard();
                System.out.println(e);

            }

        }
    }
}
