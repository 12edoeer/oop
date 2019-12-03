package view;

public class JungleView {

    public static void messageWithNextLine(Object message){System.out.println(message);}
    public static void message(Object message){System.out.print(message);}

    public static void PrintBoard(String player1Name, String player2Name, char[][] jungleBoard) {

        int z = 1;
        JungleView.messageWithNextLine("        " + player1Name);
        JungleView.messageWithNextLine("  - - - - - - -");
        for (int i = 0; i < 9; i++) {

            JungleView.message(z++ + "|");
            for (int j = 0; j < 7; j++) {
                JungleView.message(jungleBoard[i][j]);
                JungleView.message("|");
            }
            JungleView.message("\n");
        }
        JungleView.messageWithNextLine("  - - - - - - -");
        JungleView.message("  ");
        for (int i = 0; i < 7; i++) {
            char x = (char) (65 + i);
            JungleView.message(x + " ");
        }
        JungleView.message("\n");
        JungleView.messageWithNextLine("        " + player2Name);

    }
}
