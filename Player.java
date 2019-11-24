class Player{

    private String name;
    final char traps = 'T';
    final char den = 'D';
    private Chess []chess = new Chess[8];

    void ChessCreator(int x,int y,int rank) {
    	chess[rank] = new Chess(x,y);
    	chess[rank].SetRank(rank);
    }
    
    void SetName(String name) {
        this.name = name;
    }

    String GetName() {
        return name;
    }
    char GetChess(int rank) {return chess[rank].GetChess();}
    int GetX(int rank) {return chess[rank].GetX();}
    int GetY(int rank) {return chess[rank].GetY();}
}
