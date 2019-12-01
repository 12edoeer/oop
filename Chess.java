package hk.edu.polyu.comp.comp2021.jungle;

public class Chess extends Coordinate{
    private final char []CHESS = {'鼠', '貓', '狗', '狼', '豹', '虎', '獅', '象'};
    private int rank;

    Chess(int x ,int y) {
    	super(x,y);
    }

    public Chess(int x, int y, char c) {
        super(x,y);
        for(int i = 0 ; i < CHESS.length ; i++){
            if(CHESS[i]==c)
                rank = i;
        }
    }
    char GetChess() {
        return CHESS[rank];
    }

    public int GetRank(){
        return rank;
    }
    void SetRank(int rank) {this.rank = rank;}


}
