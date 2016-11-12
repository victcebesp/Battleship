import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Boat> board = new ArrayList<>();

    public List<Boat> getBoard() {
        return board;
    }

    public boolean thereIsBoatInCoordinate(Coordinate coordinate) {

        for (Boat eachBoat : board) {
            if (eachBoat.searchFor(coordinate)) return true;
        }
        return false;
    }


}
