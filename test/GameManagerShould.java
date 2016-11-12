import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * TODO:
 *
 *   - Barcos de distintas coordenadas creados bien (2 / 3 / 4 / 5)
 *   - No sobreescribir coordenadas
 *   - No pueden haber barcos de longitud mayor a 5 o menor de 2
 *   - Solo puede haber 3 barcos de longitud 2
 *   - Solo puede haber 2 barcos de longitud 3
 *   - Solo puede haber 2 barcos de longitud 4
 *   - Solo puede haber 1 barco de longitud 5
 *
 *
 */

public class GameManagerShould {
    @Test
    public void given_a_boat_with_length_one_it_should_not_be_created(){
        GameManager gameManager = new GameManager();
        Coordinate zeroCoordinate = new Coordinate(0,0);
        gameManager.getBoard().add(new Boat(zeroCoordinate, zeroCoordinate));
        assertTrue(!gameManager.thereIsBoatInCoordinate(zeroCoordinate));
    }

    @Test
    public void given_two_coordinates_a_boat_with_two_length_should_be_a_boat_in_that_coordinates (){
        GameManager gameManager = new GameManager();
        Coordinate zeroCoordinate = new Coordinate(0,0);
        Coordinate oneCoordinate = new Coordinate(0,1);
        gameManager.getBoard().add(new Boat(zeroCoordinate, oneCoordinate));

        assertTrue(gameManager.thereIsBoatInCoordinate(zeroCoordinate));
        assertTrue(gameManager.thereIsBoatInCoordinate(oneCoordinate));
    }
}
