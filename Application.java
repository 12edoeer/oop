import java.util.InputMismatchException;

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


        while (true) {

            try {
                System.out.println("Player one please input the chess that you want to move:");
                input = GetInput.Input();
                char originalChess[] = input.toCharArray();
                originalChess[0] = input.charAt(0);
                int x = originalChess[0] - 65;
                int y = originalChess[1] - 49;
                if(x<0||x>7||y<0||y>9) throw new Exception ("Input does not in range A0 to G9");


                System.out.println(x + " " + y);

                System.out.println("Target Location:");
                input = GetInput.Input().toUpperCase();
                char targetLocation[] = input.toCharArray();
                targetLocation[0] = input.charAt(0);

                int x1 = targetLocation[0] - 65;
                int y1 = targetLocation[1] - 49;
                if(x1<0||x1>7||y1<0||y1>9) throw new Exception ("Input does not in range A0 to G9");
                System.out.println(x1 + " " + y1);
                game.UserMove(x, y, x1, y1);
                game.PrintBoard();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
