package hk.edu.polyu.comp.comp2021.jungle;

public class Player{

    private String name;
    public final char traps = '阱';
    public final char den = '穴';
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
