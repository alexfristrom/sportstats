/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests.domain;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Game;
import sportstats.handler.DateHandler;

/**
 * Test class for domain object Game. Includes Test for getters and setters for
 * diffrent members
 *
 * @author alexf
 */
public class GameTest {
    
    @Test
    public void homeTeamTest() {
        Game game = new Game();
        Long id = 1L;
        
        game.setHomeTeamId(id);
        assertEquals(id, game.getHomeTeamId());
    }
    
    @Test
    public void awayTeamTest() {
        Game game = new Game();
        Long id = 1L;
        
        game.setAwayTeamId(id);
        assertEquals(id, game.getAwayTeamId());
    }
    
    @Test
    public void seasonIdTest() {
        Game game = new Game();
        Long id = 1L;
        
        game.setMatchSeasonId(id);
        assertEquals(id, game.getMatchSeasonId());
    }
    
    @Test
    public void resultIdTest() {
        Game game = new Game();
        Long id = 1L;
        
        game.setMatchResultId(id);
        assertEquals(id, game.getMatchResultId());
    }
    
    @Test
    public void roundTest() {
        Game game = new Game();
        Byte rounds = 1;
        
        game.setMatchRound(rounds);
        assertEquals(rounds, game.getMatchRound());
    }
    
    @Test
    public void dateTest() {
        DateHandler handler = new DateHandler();
        handler.addDate(2000, 1, 1);
        handler.addTime(12, 30, 0);
        
        Game game = new Game();
        game.setMatchDate(handler.getDateTime());
        
        LocalDateTime refDate = LocalDateTime.of(2000, 1, 1, 12, 30, 0);
        assertEquals(refDate, game.getMatchDate());
    }
    
    @Test
    public void spectatorTest() {
        Game game = new Game();
        Long spectators = 100L;
        
        game.setMatchSpectators(spectators);
        assertEquals(spectators, game.getMatchSpectators());
    }
    
}
