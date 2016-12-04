import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Player {

    private State currentState;
    private List<BoardType> pendingBoatsList;
    private List<Boat> board;
    private Map<Integer, BoardType> translate;

    public Player(){
        currentState = State.PLACING;
        pendingBoatsList = new ArrayList<>();
        pendingBoatsList.add(BoardType.TWO);
        pendingBoatsList.add(BoardType.TWO);
        pendingBoatsList.add(BoardType.TWO);
        pendingBoatsList.add(BoardType.THREE);
        pendingBoatsList.add(BoardType.THREE);
        pendingBoatsList.add(BoardType.FOUR);
        pendingBoatsList.add(BoardType.FOUR);
        pendingBoatsList.add(BoardType.FIVE);

        board = new ArrayList<>();

        translate = new TreeMap<>();
        translate.put(2, BoardType.TWO);
        translate.put(3, BoardType.THREE);
        translate.put(4, BoardType.FOUR);
        translate.put(5, BoardType.FIVE);

    }

    public State getState() {
        return currentState;
    }

    public int pendingBoats() {
        return pendingBoatsList.size();
    }

    public List<Boat> board() {
        return board;
    }

    public void placeBoat(Boat boat) {
        if (translate.get(boat.length()) == null){
            return;
        }

        Boolean found = lookForOverlappedCoordinates(boat);

        if (!found && pendingBoatsList.remove(translate.get(boat.length()))){
            board.add(boat);
        }

    }

    private boolean lookForOverlappedCoordinates(Boat boat) {
        return boat.getCoordinates().stream().anyMatch(coordinate1 -> {
            for(Coordinate coordinate2 : getAllCoordinates()) {
                if(coordinate1.equals(coordinate2)) return true;
            }
            return false;
        });
    }

    private List<Coordinate> getAllCoordinates() {
        return board.stream()
                    .flatMap(boat1 -> boat1.getCoordinates().stream())
                    .collect(Collectors.toList());
    }

}
