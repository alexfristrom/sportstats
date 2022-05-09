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

//    @Test
//    public void homeTeamTest() {
//        Game game = new Game();
//        Long id = 1L;
//
//        game.setHomeTeamId(id);
//        assertEquals(id, game.getHomeTeamId());
//    }
//
//    @Test
//    public void awayTeamTest() {
//        Game game = new Game();
//        Long id = 1L;
//
//        game.setAwayTeamId(id);
//        assertEquals(id, game.getAwayTeamId());
//    }
//
//    @Test
//    public void seasonIdTest() {
//        Game game = new Game();
//        Long id = 1L;
//
//        game.setMatchSeasonId(id);
//        assertEquals(id, game.getMatchSeasonId());
//    }
//
//    @Test
//    public void resultIdTest() {
//        Game game = new Game();
//        Long id = 1L;
//
//        game.setMatchResultId(id);
//        assertEquals(id, game.getMatchResultId());
//    }

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
        byte hour = 20;
        byte minute = 15;
        byte second = 0;
        handler.addTime(hour, minute, second);
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);

        Game game = new Game();
        game.setMatchDate(handler.getDateTime());

        LocalDateTime refDate = LocalDateTime.of(year, month, day, hour, minute, second);
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
