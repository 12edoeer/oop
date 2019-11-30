import java.lang.annotation.Target;

public class JungleGame {

    private char[][] jungleBoard = new char[9][7];
    private int[][] PlayerjungleBoard = new int[9][7];
    private int[][] WaterBoard = new int[9][7];
    private int[][] TrapBoard = new int[9][7];

    private Player x = new Player();
    private Player y = new Player();
    private static final char WATER = 'W';
    private static final char LAND = ' ';

    //Store the character into the jungleBoard Array
    private void Insert(char c, int x, int y, int player) {
        this.jungleBoard[y][x] = c;
        if (player == 1) {
            this.PlayerjungleBoard[y][x] = 1;
        }
        if (player == 2) {
            this.PlayerjungleBoard[y][x] = 2;
        }
        if (player == 10) {
            this.WaterBoard[y][x] = 1;
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
        System.out.println("Player two : " + x.GetName());
        System.out.println();
        for (int i = 0; i < 9; i++) {
            //System.out.println("  - - - - - - -");
            System.out.print(z++ + "|");
            for (int j = 0; j < 7; j++) {
                System.out.print(this.jungleBoard[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("  - - - - - - -");
        System.out.print("  ");
        for (int i = 0; i < 7; i++) {
            char x = (char) (65 + i);
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("  Player one : " + y.GetName());

    }


    //Create the chess in first time
    public void ChessInsert() {
        x.ChessCreator(0, 0, 6);
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
                if ((j > 0 && j < 6 && j != 3) && (i > 2 && i < 6)) {
                    this.Insert(WATER, j, i, 10);
                    continue;
                }
                this.Insert(LAND, j, i, 11);
            }
        }

        this.Insert(x.traps, 2, 0, 3);
        this.Insert(x.traps, 4, 0, 3);
        this.Insert(x.traps, 3, 1, 3);
        this.Insert(x.den, 3, 0, 3);

        this.Insert(y.traps, 2, 8, 4);
        this.Insert(y.traps, 4, 8, 4);
        this.Insert(y.traps, 3, 7, 4);
        this.Insert(y.den, 3, 8, 4);


    }

    public void UserMove(int OriX, int OriY, int targetX, int targetY, int move) {
        ////////////////////////////////////////////////////////////////////////////
        // One space move only else you are tiger or lion can jump over the river //
        ////////////////////////////////////////////////////////////////////////////
        checkPlayer(move,OriX,OriY);

        ////////////////////////////////////////////
        // Tiger and lion can jump over the river //
        ////////////////////////////////////////////

        if(this.jungleBoard[OriY][OriX]=='L'||this.jungleBoard[OriY][OriX]=='t'){
            if(OriY == targetY){

            }
        }
        if (targetX - OriX + targetY - OriY > 1) {
            if (this.jungleBoard[OriY][OriX] != 'L' || this.jungleBoard[OriY][OriX] != 't') {
                System.out.println("Lion");
            }
            System.out.println("Invalid input, you can only move vertically or horizontally with one space");
            return;
        }
        /////////////////////////////////
        // Only rat can get into river //
        /////////////////////////////////
        if (this.jungleBoard[targetY][targetX] == 'W') {
            if (this.jungleBoard[OriY][OriX] != 'r') {
                System.out.println("You can't get into river");
                return;
            }
        }

        /////////////////////////////////
        //   Cant step on your chess   //
        /////////////////////////////////
        if (this.PlayerjungleBoard[OriY][OriX] == 1) {
            if (this.PlayerjungleBoard[targetY][targetX] == 1) {
                System.out.println("Same player chess, not a valid move");
                return;
            }

        }
        if (this.PlayerjungleBoard[OriY][OriX] == 2) {
            if (this.PlayerjungleBoard[targetY][targetX] == 2) { //Same palyer chess
                System.out.println("Same player chess, not a valid move");
                return;
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
                        return;
                    }else{
                        this.PlayerjungleBoard[OriY][OriX] = 0;
                        this.jungleBoard[OriY][OriX] = '\0';
                        return;
                    }
                }
            }
        }

        Move(targetX,targetY,OriX,OriY);
        return;

    }

    public void Move(int targetX, int targetY, int OriX, int OriY) {

        this.jungleBoard[targetY][targetX] = this.jungleBoard[OriY][OriX];
        this.jungleBoard[OriY][OriX] = '\0';

        this.PlayerjungleBoard[targetY][targetX] = this.PlayerjungleBoard[OriY][OriX];
        this.PlayerjungleBoard[OriY][OriX] = '\0';

        ////////////////////////////
        //    rat move on water   //
        ////////////////////////////
        if (WaterBoard[OriY][OriX] == 1) {
            this.Insert(WATER, OriY, OriX, 10);
            jungleBoard[OriY][OriX] = 'W';
        }

        System.out.println("Moved");
        Application.moveCount = Application.moveCount+1;
    }
    public void checkPlayer(int check, int x, int y){
        if(check==0)check=+2;
            if(this.PlayerjungleBoard[y][x]==check)return;
            else{
        
                PrintBoard();
                System.out.println("YOU CANT MOVE OTHER PLAYER CHESS");
                while (true) {
                    try {
                        String input;
                        System.out.println("Please input the chess that you want to move again:");
                        input = GetInput.Input();
                        char originalChess[] = input.toCharArray();
                        originalChess[0] = input.charAt(0);
                        int inputX = originalChess[0] - 65;
                        int inputY = originalChess[1] - 49;
                        if(inputX<0||inputX>7||inputY<0||inputY>9) throw new Exception ("Input does not in range A0 to G9");
                        System.out.println(inputX + " " + inputY);
                        System.out.println("Target Location:");
                        input = GetInput.Input().toUpperCase();
                        char targetLocation[] = input.toCharArray();
                        targetLocation[0] = input.charAt(0);
                        int inputX1 = targetLocation[0] - 65;
                        int inputY1 = targetLocation[1] - 49;
                        if(inputX1<0||inputX1>7||inputY1<0||inputY1>9) throw new Exception ("Input does not in range A0 to G9");
                        System.out.println(inputX1 + " " + inputY1);
                        UserMove(inputX, inputY, inputX1, inputY1,check);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }





    }
    public Boolean Fight(int a, int b, int c, int d) {
        Chess Chess1 = new Chess(a, b, jungleBoard[b][a]);
        Chess Chess2 = new Chess(c, d, jungleBoard[d][c]);
        System.out.println("Chess one is: " + Chess1.GetRank());
        System.out.println("Chess two is: " + Chess2.GetRank());

        if (Chess1.GetRank() == 0 && (Chess2.GetRank() == 7)) {
            System.out.println("Win");
            return true;
        }
        if (Chess1.GetRank() == 7 && (Chess2.GetRank() == 0)) {
            System.out.println("Lose1");
            return false;
        }
        if (Chess1.GetRank() >= Chess2.GetRank()) {
            System.out.println("Win");
            return true;
        }else
        {
            System.out.println("Lose");
            return false;
        }

    }
}