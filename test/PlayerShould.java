import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerShould {
    private static Player player;

    /**
     * TODO PLAYER
     *
     *  - Cuando haya situado todos los barcos pasa a JUEGO
     *  - En modo JUEGO no puede añadir barcos nuevos
     */

    @Before
    public void before(){
        player = new Player();
    }

    @Test
    public void a_player_should_start_in_state_PLACING (){
        assertEquals(State.PLACING, player.getState());
    }

    @Test
    public void a_player_should_start_with_eight_boats(){
        assertEquals(8, player.pendingBoats());
    }

    @Test
    public void be_able_to_place_one_less_boat_when_a_boat_is_placed(){
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(0,0), new Coordinate(0,1));
        player.placeBoat(new Boat(coordinates));

    assertEquals(7, player.pendingBoats());
        assertEquals(1, player.board().size());
    }

    @Test
    public void not_be_able_to_place_more_boats_of_the_same_type_than_restricted_number(){
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(0,0), new Coordinate(0,1));
        player.placeBoat(new Boat(coordinates));

        assertEquals(7, player.pendingBoats());
        assertEquals(1, player.board().size());

        List<Coordinate> coordinates1 = Arrays.asList(new Coordinate(1,0), new Coordinate(1,1));
        player.placeBoat(new Boat(coordinates1));

        assertEquals(6, player.pendingBoats());
        assertEquals(2, player.board().size());

        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(2,0), new Coordinate(2,1));
        player.placeBoat(new Boat(coordinates2));

        assertEquals(5, player.pendingBoats());
        assertEquals(3, player.board().size());

        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(3,0), new Coordinate(3,1));
        player.placeBoat(new Boat(coordinates3));

        assertEquals(5, player.pendingBoats());
        assertEquals(3, player.board().size());
    }

    @Test
    public void not_have_two_overlapping_coordinates_for_different_boats (){
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(0,0), new Coordinate(0,1));
        player.placeBoat(new Boat(coordinates));

        assertEquals(7, player.pendingBoats());
        assertEquals(1, player.board().size());

        List<Coordinate> coordinates1 = Arrays.asList(new Coordinate(0,0), new Coordinate(1,0));
        player.placeBoat(new Boat(coordinates1));

        assertEquals(7, player.pendingBoats());
        assertEquals(1, player.board().size());
    }

    @Test
    public void change_to_playing_mode_when_all_boats_have_been_placed (){
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(0,0),new Coordinate(0,1));
        List<Coordinate> coordinates1 = Arrays.asList(new Coordinate(1,0),new Coordinate(2,0));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(3,0),new Coordinate(3,1));
        player.placeBoat(new Boat(coordinates));
        player.placeBoat(new Boat(coordinates1));
        player.placeBoat(new Boat(coordinates2));

        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(4,0),
                new Coordinate(4,1),
                new Coordinate(4,2));

        List<Coordinate> coordinates4 = Arrays.asList(new Coordinate(2,4),
                new Coordinate(3,4),
                new Coordinate(4,4));
        player.placeBoat(new Boat(coordinates3));
        player.placeBoat(new Boat(coordinates4));

        List<Coordinate> coordinates5 = Arrays.asList(new Coordinate(5,0),
                new Coordinate(5,1),
                new Coordinate(5,2),
                new Coordinate(5,3));

        List<Coordinate> coordinates6 = Arrays.asList(new Coordinate(0,7),
                new Coordinate(1,7),
                new Coordinate(2,7),
                new Coordinate(3,7));
        player.placeBoat(new Boat(coordinates5));
        player.placeBoat(new Boat(coordinates6));
        assertEquals(State.PLACING, player.getState());

        List<Coordinate> coordinates7 = Arrays.asList(new Coordinate(1,5),
                new Coordinate(2,5),
                new Coordinate(3,5),
                new Coordinate(4,5),
                new Coordinate(5,5));
        player.placeBoat(new Boat(coordinates7));

        assertEquals(0,player.pendingBoats());
        assertEquals(8, player.board().size());
        assertEquals(State.PLAYING, player.getState());

        List<Coordinate> coordinates8 = Arrays.asList(new Coordinate(2,0),new Coordinate(7,7));
        player.placeBoat(new Boat(coordinates8));

        assertEquals(0, player.pendingBoats());
        assertEquals(8, player.board().size());
        assertEquals(State.PLAYING, player.getState());

    }


}
