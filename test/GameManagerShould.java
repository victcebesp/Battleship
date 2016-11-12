import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * TODO:
 *
 *   - Barcos de distintas coordenadas creados bien (2 / 3 / 4 / 5)
 *   - No sobreescribir coordenadas
 *   - No pueden haber barcos de longitud mayor a 5 o menor de 2
 *   -
 *
 *
 */

public class GameManagerShould {
    @Test
    public void given_a_coordinate_a_boat_with_one_length_should_be_a_boat_in_that_coordinate (){
        GameManager gameManager = new GameManager();
        Coordinate zeroCoordinate = new Coordinate(0,0);
        gameManager.getBoard().add(new Boat(zeroCoordinate, zeroCoordinate));
        assertTrue(gameManager.thereIsBoatInCoordinate(zeroCoordinate));
    }
    
}
