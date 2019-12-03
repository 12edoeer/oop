package model;

public class Player {

    final public char traps = 'T';
    final public char den = 'D';
    private String name;
    private Chess[] chess = new Chess[8];

    public void ChessCreator(int x, int y, int rank) {
        chess[rank] = new Chess(x, y);
        chess[rank].SetRank(rank);
    }

    public boolean isYourOwnChess(int x, int y) {

        for (int i = 0; i < 8; i++) {
            if (x == this.GetX(i) && y == this.GetY(i)) {
                return true;
            }
        }

        return false;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public char GetChess(int rank) {
        return chess[rank].GetChess();
    }

    public void chessCoordinateUpdate(int oriX, int oriY, int newX, int newY) {
        int rank = -1;

        for (int i = 0; i < 8; i++) {
            if (oriX == this.GetX(i) && oriY == this.GetY(i)) {
                rank = i;
            }
        }

        if (rank != -1)
            chess[rank].SetCoordinate(newX, newY);
    }


    public int GetX(int rank) {
        return chess[rank].GetX();
    }

    public int GetY(int rank) {
        return chess[rank].GetY();
    }
}
