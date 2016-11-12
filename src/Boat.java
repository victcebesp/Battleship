import java.util.ArrayList;
import java.util.List;

public class Boat{

    private List<Coordinate> coordinateList = new ArrayList<>();

    public Boat(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        addCoordinate(firstCoordinate, secondCoordinate);
    }

    private void addCoordinate(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        if (firstCoordinate.xPos() == secondCoordinate.xPos()){

            int firstPos = firstCoordinate.yPos();
            int secondPos = secondCoordinate.yPos();
            for (int i = firstPos; i <= secondPos; i++) {
                coordinateList.add(new Coordinate(firstCoordinate.xPos(), i));
            }

        }else{

            int firstPos = firstCoordinate.xPos();
            int secondPos = secondCoordinate.xPos();
            for (int i = firstPos; i <= secondPos; i++) {
                coordinateList.add(new Coordinate(i, firstCoordinate.yPos()));
            }

        }
    }

    public boolean searchFor(Coordinate coordinate) {

        for (Coordinate anyCoordinate : coordinateList) {
            if (anyCoordinate.equals(coordinate)){
                return true;
            }
        }

        return false;
    }
}
