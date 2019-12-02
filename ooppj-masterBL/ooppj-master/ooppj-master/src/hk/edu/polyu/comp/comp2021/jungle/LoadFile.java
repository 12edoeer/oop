package hk.edu.polyu.comp.comp2021.jungle;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class LoadFile {
    public static int[][] LoadPlayerjungleBoard() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("output.txt")));
        int[][] PlayerjungleBoard = new int[9][7];
        for (int i = 0; i < 9; i++) {
            String[] line = sc.nextLine().trim().split("");
            for (int j = 0; j < 7; j++) {
                PlayerjungleBoard[i][j] = Integer.parseInt(line[j]);
            }
        }
        return PlayerjungleBoard;
    }

    public static char[][] LoadjungleBoard() throws Exception {
        BufferedReader sc = new BufferedReader(new FileReader("output.txt"));
        String[] string = new String[9];
        char jungleBoard[][] = new char[string.length][7];//make this 2d
        for (int i = 0; i < 2; i++) {
            //char JBline = sc.nextLine().trim().split("");
            for (int j = 0; j < 9; j++) {
                String JBline = sc.readLine();
                if (i > 0) {
                    jungleBoard[j] = JBline.toCharArray();
                }
            }
        }
        return jungleBoard;
    }
}


