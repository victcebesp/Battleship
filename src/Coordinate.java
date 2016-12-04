public class Coordinate {

    private final int xPosition;
    private final int yPosition;

    public Coordinate(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition(){
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }

    @Override
    public boolean equals(Object o){
        Coordinate coordinate = (Coordinate)o;
        return this.xPosition == coordinate.getxPosition() && this.yPosition == coordinate.getyPosition();
    }
}
