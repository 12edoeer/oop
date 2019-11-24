class Chess extends Coordinate{
    private final char []CHESS = {'r', 'c', 'd', 'w', 'l', 't', 'L', 'E'};
    private int rank;

    Chess(int x ,int y) {
    	super(x,y);
    }

    char GetChess() {
        return CHESS[rank];
    }

    void SetRank(int rank) {this.rank = rank;}


}
