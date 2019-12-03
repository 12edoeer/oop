package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.JungleGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SaveFile {
    public static void main(int[][] playerjungleBoard, char[][] jungleBoard) {
        System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        try (
                PrintStream output = new PrintStream(new File("output.txt"));) {
            for (int i = 0; i < playerjungleBoard.length; i++) {
                String s= "";
                for (int j = 0; j < playerjungleBoard[i].length; j++) {
                    s+= playerjungleBoard[i][j] ;
                }
                output.println(s);
            }
            for (int i = 0; i < jungleBoard.length; i++) {
                String s= "";
                for (int j = 0; j < jungleBoard[i].length; j++) {
                    s+=  jungleBoard[i][j] ;
                }
                output.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}