import java.util.*;

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

    public void placeBoat(Boat boat) {
        if (translate.get(boat.length()) == null){
            return;
        }



        if (pendingBoatsList.remove(translate.get(boat.length()))){
            board.add(boat);
        }

    }


    public List<Boat> board() {
        return board;
    }
}
