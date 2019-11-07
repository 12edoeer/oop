package hk.edu.polyu.comp.comp2021.jungle.model;

public class JungleGame {

    private char[][] jungleBoard = new char[9][7];
    private Player x = new Player();
    private Player y = new Player();
    private static final char WATER = 'W';
    private static final char LAND = ' ';

    //Store the character into the jungleBoard Array
    private void Insert(char c, int x, int y) {
        this.jungleBoard[y][x] = c;
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

        int z = 9;
        System.out.println("        " + x.GetName());
        for (int i = 0; i < 9; i++) {
            System.out.println("  - - - - - - -");
            System.out.print(z-- + "|");
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
        System.out.println("        " + y.GetName());

    }


    //Create the chess in first time
    public void ChessInsert() {
        x.ChessCreator(0, 0, 6);
        this.Insert(x.GetChess(6), x.GetX(6),x.GetY(6));

        x.ChessCreator(6,0,5);
        this.Insert(x.GetChess(5), x.GetX(5),x.GetY(5));

        x.ChessCreator(1,1,2);
        this.Insert(x.GetChess(2),x.GetX(2),x.GetY(2));

        x.ChessCreator(5, 1, 1);
        this.Insert(x.GetChess(1), x.GetX(1),x.GetY(1));

        x.ChessCreator(0, 2, 0);
        this.Insert(x.GetChess(0),x.GetX(0),x.GetY(0));

        x.ChessCreator(2, 2, 4);
        this.Insert(x.GetChess(4),x.GetX(4),x.GetY(4));

        x.ChessCreator(4, 2, 3);
        this.Insert(x.GetChess(3),x.GetX(3),x.GetY(3));

        x.ChessCreator(6, 2, 7);
        this.Insert(x.GetChess(7),x.GetX(7),x.GetY(7));

        y.ChessCreator(0, 8, 5);
        this.Insert(x.GetChess(5), y.GetX(5),y.GetY(5));

        y.ChessCreator(6, 8, 6);
        this.Insert(x.GetChess(6), y.GetX(6),y.GetY(6));

        y.ChessCreator(1, 7, 1);
        this.Insert(x.GetChess(1), y.GetX(1),y.GetY(1));

        y.ChessCreator(5, 7, 2);
        this.Insert(x.GetChess(2),  y.GetX(2),y.GetY(2));

        y.ChessCreator(0, 6, 7);
        this.Insert(x.GetChess(7),  y.GetX(7),y.GetY(7));

        y.ChessCreator(2, 6, 3);
        this.Insert(x.GetChess(3),  y.GetX(3),y.GetY(3));

        y.ChessCreator(4, 6, 4);
        this.Insert(x.GetChess(4), y.GetX(4),y.GetY(4));

        y.ChessCreator(6, 6, 0);
        this.Insert(x.GetChess(0), y.GetX(0),y.GetY(0));
    }

    //Build the board with no chess
    public JungleGame() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if ((j > 0 && j < 6 && j != 3) && (i > 2 && i < 6)) {
                    this.Insert(WATER, j, i);
                    continue;
                }
                this.Insert(LAND, j, i);
            }
        }

        this.Insert(x.traps, 2, 0);
        this.Insert(x.traps, 4, 0);
        this.Insert(x.traps, 3, 1);
        this.Insert(y.traps, 2, 8);
        this.Insert(y.traps, 4, 8);
        this.Insert(y.traps, 3, 7);
        this.Insert(x.den, 3, 0);
        this.Insert(y.den, 3, 8);




    }
}