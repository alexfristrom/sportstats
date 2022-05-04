/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.repository.GameRepository;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.*;
import sportstats.domain.Game;

/**
 *
 * @author David Sjöblom
 */
public class GameServiceTest {


    /**
     * Test of saveGame method, of class GameService.
     */
    @Test
    public void testSaveGame() {
        
        Game game = new Game();
//        when(repo.save(game)).thenReturn(game);
        GameRepository gR  = Mockito.mock(GameRepository.class);
       
        game = service.saveGame(game);
        
        assertTrue(game == null);
    }

    /**
     * Test of getGame method, of class GameService.
     */
    @Test
    public void testGetGame() {
    }

    /**
     * Test of getAllGame method, of class GameService.
     */
    @Test
    public void testGetAllGame() {
    }
    
}
