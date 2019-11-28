public class Chess extends Coordinate{
    private final char []CHESS = {'r', 'c', 'd', 'w', 'l', 't', 'L', 'E'};
    private int rank;

    Chess(int x ,int y) {
    	super(x,y);
    }

    Chess(int x ,int y,char c) {
        super(x,y);
        for(int i = 0 ; i < CHESS.length ; i++){
            if(CHESS[i]==c)
                rank = i;
        }
    }
    char GetChess() {
        return CHESS[rank];
    }

    int GetRank(){
        return rank;
    }
    void SetRank(int rank) {this.rank = rank;}


}
