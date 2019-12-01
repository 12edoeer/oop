package hk.edu.polyu.comp.comp2021.jungle;

class Coordinate {
    private int x, y;


    Coordinate(int x, int y) {
        SetCoordinate(x, y);

    }

    private void SetCoordinate(int x, int y) {
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
