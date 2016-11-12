public class Coordinate {
    private final int xPos;
    private final int yPos;

    public Coordinate(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int xPos(){
        return xPos;
    }

    public int yPos(){
        return yPos;
    }

    public boolean equals(Object obj){

        return this.xPos() == ((Coordinate) obj).xPos() &&
               this.yPos() == ((Coordinate) obj).yPos();


    }
}
