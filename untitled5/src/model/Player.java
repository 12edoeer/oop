package model;

public class Player{

    final public char traps = 'T';
    final public char den ='D';
    private String name;

    private Chess []chess = new Chess[8];

    public void ChessCreator(int x, int y, int rank) {
    	chess[rank] = new Chess(x,y);
    	chess[rank].SetRank(rank);
    }
    
    public void SetName(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }
    public char GetChess(int rank) {return chess[rank].GetChess();}
    public int GetX(int rank) {return chess[rank].GetX();}
    public int GetY(int rank) {return chess[rank].GetY();}
}
