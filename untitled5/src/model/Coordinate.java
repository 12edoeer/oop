package model;

class Coordinate {
    private int x, y;


    Coordinate(int x, int y) {
        SetCoordinate(x, y);

    }

    public void SetCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int GetX() {
        return x;
    }

    int GetY() {
        return y;
    }


}
