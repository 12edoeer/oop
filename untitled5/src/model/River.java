package model;

public class River {
    private Coordinate[] coordinates = new Coordinate[12];

    void setCoordinates(int waterBoard, int x, int y) {
        coordinates[waterBoard].SetCoordinate(x, y);
    }

    char getWaterChar(){return 'W';}

}
