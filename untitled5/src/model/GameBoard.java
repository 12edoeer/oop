package model;

public class GameBoard {
    private char[][] jungleBoard = new char[9][7];
    private River river = new River();

    public GameBoard() {
        int waterBoard = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if ((j > 0 && j < 6 && j != 3) && (i > 2 && i < 6)) {
                    //river.setCoordinates(waterBoard, j, i);
                    this.Insert(river.getWaterChar(), j, i);
                    continue;
                }
                this.Insert(' ', j, i);
            }
        }
    }

    public char getChessChar(int x, int y) {
        return jungleBoard[y][x];
    }


    public void Insert(char c, int x, int y) {
        jungleBoard[y][x] = c;


    }

    public char[][] getJungleBoard() {
        return jungleBoard;
    }


}

