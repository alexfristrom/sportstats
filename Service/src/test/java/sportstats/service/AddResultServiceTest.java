/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
        short homeTeamScore = 5;
        short awayTeamScore = 15;
        Mockito.when(gameR.getById(gameId)).thenReturn(tmpGame);
        
        Game game = service.addResultScore(1L, homeTeamScore, awayTeamScore);

        assertEquals(15, game.getResult().getAwayTeamScore());
        assertEquals(5, game.getResult().getHomeTeamScore());

    }

    /**
     * Test of addResultMeta method, of class AddResultService.
     */
    @Test
    public void testAddResultMeta() {
        gameR = mock(GameRepository.class);
        service = new AddResultService(gameR);

        Game tmpGame = new Game();
        Result tmpResult = new Result();
        tmpGame.setResult(tmpResult);

        Long gameId = 1l;

        Mockito.when(gameR.getById(gameId)).thenReturn(tmpGame);
        Game game = service.addResultMeta(gameId, true, 20L, true);

        assertEquals(true, game.getResult().getOvertime());
        assertEquals(true, game.getResult().getPenalty());
        assertEquals(20L, game.getResult().getOvertimeMinutes());

    }

    /**
     * Test of addGameResult method, of class AddResultService.
     */
    @Test
    public void testAddGameResult() {

        gameR = mock(GameRepository.class);
        service = new AddResultService(gameR);

        Game tmpGame = new Game();
        Result tmpResult = new Result();
        tmpGame.setResult(tmpResult);

        Long gameId = 1l;

        Mockito.when(gameR.getById(gameId)).thenReturn(tmpGame);
        short homeTeamScore = 5;
        short awayTeamScore = 15;
        Game game = service.addGameResult(gameId, homeTeamScore, awayTeamScore, true, 20L, true);

        assertEquals(15, game.getResult().getAwayTeamScore());
        assertEquals(5, game.getResult().getHomeTeamScore());
        assertEquals(true, game.getResult().getOvertime());
        assertEquals(true, game.getResult().getPenalty());
        assertEquals(20L, game.getResult().getOvertimeMinutes());

    }

}
