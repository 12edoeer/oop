package hk.edu.polyu.comp.comp2021.jungle.model;

import hk.edu.polyu.comp.comp2021.jungle.*;

import java.lang.annotation.Target;

public class JungleGame {

    private char[][] jungleBoard = new char[9][7];
    private int[][] PlayerjungleBoard = new int[9][7];
    private int[][] WaterBoard = new int[9][7];
    private int[][] TrapBoard = new int[9][7];
    private int[][] DenBoard = new int[9][7];
    private Player x = new Player();
    private Player y = new Player();
    private static final char WATER = '河';
    private static final char LAND = '　';
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    //Store the character into the jungleBoard Array
    private void Insert(char c, int x, int y, int type) {
        this.jungleBoard[y][x] = c;
        if (type == 1) {
            this.PlayerjungleBoard[y][x] = 1;
        }
        if (type == 2) {
            this.PlayerjungleBoard[y][x] = 2;
        }
        if (type == 10) {
            this.WaterBoard[y][x] = 1;
        }
        if (type == 11) {
            this.WaterBoard[y][x] =2;
        }
        this.WaterBoard[2][0] = 0;
        this.WaterBoard[2][6] = 0;
        this.WaterBoard[6][0] = 0;
        this.WaterBoard[6][6] = 0;

        if (type == 3) {
            this.TrapBoard[y][x] = 1;
        }
        if (type == 4) {
            this.TrapBoard[y][x] = 2;
        }
        if (type == 5) {
            this.DenBoard[y][x] = 1;
        }
        if (type == 6) {
            this.DenBoard[y][x] = 2;
        }

    }

    //Get the name of Players
    public void getName() {
        System.out.print("Please input player 1 name:");
        x.SetName(GetInput.Input());
        System.out.print("Please input player 2 name:");
        y.SetName(GetInput.Input());
    }

    // The function print the jungleBoard and user name
    public void PrintBoard() {

        int z = 1;
        System.out.println();
        System.out.println("Player one : " + x.GetName());

        for (int i = 0; i < 9; i++) {
            //System.out.println("  - - - - - - -");
            System.out.print(z++ + "|");
            for (int j = 0; j < 7; j++) {
                if(WaterBoard[i][j]==1){
                    System.out.print(ANSI_BLUE+this.jungleBoard[i][j]+ANSI_RESET);
                }else if(this.PlayerjungleBoard[i][j]==2){
                    System.out.print(ANSI_RED+this.jungleBoard[i][j]+ANSI_RESET);
                }
                else{
                    System.out.print(ANSI_BLACK+this.jungleBoard[i][j]+ANSI_RESET);
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("　一 一 一 一 一 一 一");
        System.out.print("  ");
        for (int i = 0; i < 7; i++) {
            char x = (char) (65 + i);
            System.out.print(x + "　");
        }
        System.out.println();
        System.out.println("Player two : " + y.GetName());

    }


    //Create the chess in first time
    public void ChessInsert() {
        x.ChessCreator(1, 2, 6);
        this.Insert(x.GetChess(6), x.GetX(6), x.GetY(6), 1);

        x.ChessCreator(6, 0, 5);
        this.Insert(x.GetChess(5), x.GetX(5), x.GetY(5), 1);

        x.ChessCreator(1, 1, 2);
        this.Insert(x.GetChess(2), x.GetX(2), x.GetY(2), 1);

        x.ChessCreator(5, 1, 1);
        this.Insert(x.GetChess(1), x.GetX(1), x.GetY(1), 1);

        x.ChessCreator(0, 2, 0);
        this.Insert(x.GetChess(0), x.GetX(0), x.GetY(0), 1);

        x.ChessCreator(2, 2, 4);
        this.Insert(x.GetChess(4), x.GetX(4), x.GetY(4), 1);

        x.ChessCreator(4, 2, 3);
        this.Insert(x.GetChess(3), x.GetX(3), x.GetY(3), 1);

        x.ChessCreator(6, 2, 7);
        this.Insert(x.GetChess(7), x.GetX(7), x.GetY(7), 1);
        ////////////////////////////////////
        ////////////////////////////////////
        ///////////////////////////////
        y.ChessCreator(0, 8, 5);
        this.Insert(x.GetChess(5), y.GetX(5), y.GetY(5), 2);

        y.ChessCreator(6, 8, 6);
        this.Insert(x.GetChess(6), y.GetX(6), y.GetY(6), 2);

        y.ChessCreator(1, 7, 1);
        this.Insert(x.GetChess(1), y.GetX(1), y.GetY(1), 2);

        y.ChessCreator(5, 7, 2);
        this.Insert(x.GetChess(2), y.GetX(2), y.GetY(2), 2);

        y.ChessCreator(0, 6, 7);
        this.Insert(x.GetChess(7), y.GetX(7), y.GetY(7), 2);

        y.ChessCreator(2, 6, 3);
        this.Insert(x.GetChess(3), y.GetX(3), y.GetY(3), 2);

        y.ChessCreator(4, 6, 4);
        this.Insert(x.GetChess(4), y.GetX(4), y.GetY(4), 2);

        y.ChessCreator(6, 6, 0);
        this.Insert(x.GetChess(0), y.GetX(0), y.GetY(0), 2);
    }

    //Build the board with no chess
    public JungleGame() {


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {

                if ((j >= 0 && j <= 6 ) && (i > 1 && i < 7)) {
                    this.Insert('\0', j, i, 11);
                }

                if ((j > 0 && j < 6 && j != 3) && (i > 2 && i < 6)) {
                    this.Insert(WATER, j, i, 10);
                    continue;
                }
                this.Insert(LAND, j, i, 0);
            }
        }

        this.Insert(x.traps, 2, 0, 3);
        this.Insert(x.traps, 4, 0, 3);
        this.Insert(x.traps, 3, 1, 3);
        this.Insert(x.den, 3, 0, 5);

        this.Insert(y.traps, 2, 8, 4);
        this.Insert(y.traps, 4, 8, 4);
        this.Insert(y.traps, 3, 7, 4);
        this.Insert(y.den, 3, 8, 6);


    }

    public int UserMove(int OriX, int OriY, int targetX, int targetY) {
        ////////////////////////////////////////////////////////////////////////////
        // One space move only else you are tiger or lion can jump over the river //
        ////////////////////////////////////////////////////////////////////////////
        if(targetX==OriX && targetY == OriY){
            System.out.println("You need to move");
            return -1;
        }

        if(DenBoard[targetY][targetX]==1||DenBoard[targetY][targetX]==2) {
            System.out.println(DenBoard[targetY][targetX]+":"+PlayerjungleBoard[OriY][OriX]);
            if (DenBoard[targetY][targetX] == PlayerjungleBoard[OriY][OriX]) {
                System.out.println("Cant step on own den");
                return -1;
            }
        }
        ////////////////////////////////////////////
        // Tiger and lion can jump over the river //
        ////////////////////////////////////////////
        if (this.jungleBoard[OriY][OriX] == '獅' || this.jungleBoard[OriY][OriX] == '虎') {
            if(this.WaterBoard[OriY][OriX] == 2 &&this.WaterBoard[targetY][targetX]==2){
                if(OriX==targetX||OriY==targetY && Math.abs(targetX-OriX)==3 && Math.abs(targetY-OriY)==4){
                    if(targetX==OriX){
                        if(this.PlayerjungleBoard[3][OriX]!=0 ||this.PlayerjungleBoard[4][OriX]!=0||this.PlayerjungleBoard[5][OriX]!=0){
                            System.out.println("Cant Cross , have mice inside the river");
                            return -1;
                        }
                    }else if (targetY==OriY) {
                      if(OriX==0) {
                          if (this.PlayerjungleBoard[OriY][1] != 0 || this.PlayerjungleBoard[OriY][2] != 0) {
                              System.out.println("Cant Cross , have mice inside the river");
                              return -1;
                          }
                      }
                      else if(OriX==3){
                          if(targetX<OriX){
                              if (this.PlayerjungleBoard[OriY][1] != 0 || this.PlayerjungleBoard[OriY][2] != 0) {
                                  System.out.println("Cant Cross , have mice inside the river");
                                  return -1;
                              }
                          }
                          else if(targetX>OriX){
                              if (this.PlayerjungleBoard[OriY][4] != 0 || this.PlayerjungleBoard[OriY][5] != 0) {
                                  System.out.println("Cant Cross , have mice inside the river");
                                  return -1;
                              }
                          }
                      }
                      else if(OriX==6){
                              if(this.PlayerjungleBoard[OriY][4]!=0 ||this.PlayerjungleBoard[OriY][5]!=0){
                                  System.out.println("Cant Cross , have mice inside the river");
                                  return -1;
                      }
                    }

                }
                    if (Fight(OriX, OriY, targetX, targetY) == true) {
                        Move(targetX,targetY,OriX,OriY);
                        return 1;
                    }else{
                        this.PlayerjungleBoard[OriY][OriX] = 0;
                        this.jungleBoard[OriY][OriX] = '　';
                        return 1;
                    }
                }
            }
        }
        if (Math.abs(targetX - OriX) + Math.abs(targetY - OriY) > 1) {
            System.out.println("Invalid input, you can only move vertically or horizontally with one space");
            return -1;
        }


        /////////////////////////////////
        // Only rat can get into river //
        /////////////////////////////////
        if (this.jungleBoard[targetY][targetX] == '河') {
            if (this.jungleBoard[OriY][OriX] != '鼠') {
                System.out.println("You can't get into river");
                return -1 ;
            }
        }
        if (this.jungleBoard[OriY][OriX] == '鼠') {
            if (this.WaterBoard[OriY][OriX] == 1) {
                if(this.WaterBoard[targetY][targetX]==1) {
                    if (this.jungleBoard[targetY][targetX] == '鼠')
                    {
                        Fight(OriX,OriY,targetX,targetY);
                    }
                }else{
                    System.out.println("You can't eat enemy on land");
                    return  -1;
                }


            }
        }

        /////////////////////////////////
        //   Cant step on your chess   //
        /////////////////////////////////
        if (this.PlayerjungleBoard[OriY][OriX] == 1) {
            if (this.PlayerjungleBoard[targetY][targetX] == 1) {
                System.out.println("Same player chess, not a valid move");
                return -1;
            }

        }

        if (this.PlayerjungleBoard[OriY][OriX] == 2) {
            if (this.PlayerjungleBoard[targetY][targetX] == 2) { //Same palyer chess
                System.out.println("Same player chess, not a valid move");
                return -1;
            }


        }

        /////////////////////////////////
        //     Step on enemy chess     //
        /////////////////////////////////
        if (this.PlayerjungleBoard[OriY][OriX] == 1 || this.PlayerjungleBoard[OriY][OriX] == 2) {
            if (this.PlayerjungleBoard[targetY][targetX] == 1 || this.PlayerjungleBoard[targetY][targetX] == 2) {
                if (this.PlayerjungleBoard[targetY][targetX] != this.PlayerjungleBoard[OriY][OriX]) {
                    if (Fight(OriX, OriY, targetX, targetY) == true) {
                        Move(targetX,targetY,OriX,OriY);
                        return 1;
                    }else{
                        this.PlayerjungleBoard[OriY][OriX] = 0;
                        this.jungleBoard[OriY][OriX] = '　';
                        return 1;
                    }
                }
            }
        }


        Move(targetX,targetY,OriX,OriY);
        return 1;

    }

    public void Move(int targetX, int targetY, int OriX, int OriY) {

        this.jungleBoard[targetY][targetX] = this.jungleBoard[OriY][OriX];
        this.jungleBoard[OriY][OriX] = '　';

        this.PlayerjungleBoard[targetY][targetX] = this.PlayerjungleBoard[OriY][OriX];
        this.PlayerjungleBoard[OriY][OriX] = 0;

        ////////////////////////////
        //    rat move on water   //
        ////////////////////////////
        if (WaterBoard[OriY][OriX] == 1) {
            this.Insert(WATER, OriX, OriY, 10);
            this.jungleBoard[OriY][OriX] = '河';
        }

        if (TrapBoard[OriY][OriX] == 1||TrapBoard[OriY][OriX] == 2) {
            this.Insert(x.traps, OriX, OriY, TrapBoard[OriY][OriX]+2);
            this.jungleBoard[OriY][OriX] = '阱';
        }

        if (DenBoard[OriY][OriX] == 1||DenBoard[OriY][OriX] == 2) {
            this.Insert(x.traps, OriX, OriY, TrapBoard[OriY][OriX]+4);
            this.jungleBoard[OriY][OriX] = '穴';
        }


        System.out.println("Moved");

        if(DenBoard[targetY][targetX]==1||DenBoard[targetY][targetX]==2) {
            System.out.println("Steped on 穴");
            if(DenBoard[targetY][targetX]!=PlayerjungleBoard[targetY][targetX]) {
                System.out.println("Player "+PlayerjungleBoard[targetY][targetX]+" win");
                PrintBoard();
                Application.run = false;
                Win();
            }
        }
        return;
    }

    public int getPlayerjungleBoard(int x, int y){
        return PlayerjungleBoard[y][x];
    }




    public boolean Fight(int a, int b, int c, int d) {

        Chess Chess1 = new Chess(a, b, jungleBoard[b][a]);
        Chess Chess2 = new Chess(c, d, jungleBoard[d][c]);
        System.out.println("Chess one rank is: " + Chess1.GetRank());
        System.out.println("Chess two rank is: " + Chess2.GetRank());

        if(TrapBoard[d][c]==PlayerjungleBoard[d][c]) {

            if (Chess1.GetRank() == 0 && (Chess2.GetRank() == 7)) {
                System.out.println("Win2");
                return true;
            }
            if (Chess1.GetRank() == 7 && (Chess2.GetRank() == 0)) {
                System.out.println("Lose3");
                return false;
            }
            if (Chess1.GetRank() >= Chess2.GetRank()) {
                System.out.println("Win4");
                return true;
            } else {
                System.out.println("Lose2");
                return false;
            }
        }else{
            System.out.println("Win5");
            return true;
        }
    }

    public void Win(){
        System.out.println("FINISHHHHHHHHHHHHHHHHHHHHH");
        System.exit(0);

    }
    //Save
    public void Save(){
        SaveFile.main(PlayerjungleBoard, jungleBoard);
    }

    //Load
    public void Load(){
        try {
            PlayerjungleBoard = LoadFile.LoadPlayerjungleBoard();
            jungleBoard = LoadFile.LoadjungleBoard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}