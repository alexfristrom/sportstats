/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.repository.GameRepository;

/**
 *
 * @author alexf
 */
public class AddResultServiceTest {
    
    @Mock
    
    private GameRepository gameR;

     AddResultService service;
    /**
     * Test of addResultScore method, of class AddResultService.
     */
    @Test
    public void testAddResultScore() {
        gameR = mock(GameRepository.class);
        service = new AddResultService(gameR);
        
        Game tmpGame = new Game();
        Result tmpResult = new Result();
        tmpGame.setResult(tmpResult);
        
        Long gameId = 1l;
        
        Mockito.when(gameR.getById(gameId)).thenReturn(tmpGame);
      
        Game game = service.addResultScore(1L, 5, 15);
        
        assertEquals(15, game.getResult().getAwayTeamScore());
        assertEquals(5, game.getResult().getHomeTeamScore());
        
    }

    /**
     * Test of addResultMeta method, of class AddResultService.
     */
    @Test
    public void testAddResultMeta() {
       
    }

    /**
     * Test of addGameResult method, of class AddResultService.
     */
    @Test
    public void testAddGameResult() {
        
    }
    
}
