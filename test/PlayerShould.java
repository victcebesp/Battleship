import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerShould {
    private static Player player;

    /**
     * TODO PLAYER
     *  - Barcos de distintas coordenadas creados bien (2 / 3 / 4 / 5)
     *  - No sobreescribir coordenadas
     *  - No pueden haber barcos de longitud mayor a 5 o menor de 2
     *  - Solo puede haber 3 barcos de longitud 2
     *  - Solo puede haber 2 barcos de longitud 3
     *  - Solo puede haber 2 barcos de longitud 4
     *  - Solo puede haber 1 barco de longitud 5
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


}
