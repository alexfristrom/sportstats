/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Game;

/**
 *
 * @author max
 */
public class GameAddMetaDataTest {
    
    public GameAddMetaDataTest() {
    }

    /**
     * Test of AddSpectators method, of class GameAddMetaData.
     */
    @Test
    public void testAddSpectators() {
        Game game = new Game();
        game.setSpectators(50);
        assertEquals(50, game.getSpectators());
    }
    
}
