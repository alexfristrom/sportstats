/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests.domain;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Season;
import sportstats.domain.Team;
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
        Team team = new Team();

        game.setHomeTeam(team);
        assertEquals(team, game.getHomeTeam());
    }

    @Test
    public void awayTeamTest() {
        Game game = new Game();
        Team team = new Team();

        game.setAwayTeam(team);
        assertEquals(team, game.getAwayTeam());
    }

    @Test
    public void seasonTest() {
        Game game = new Game();
        Season season = new Season();

        game.setSeason(season);
        assertEquals(season, game.getSeason());
    }

    @Test
    public void resultTest() {
        Game game = new Game();
        Result result = new Result();

        game.setResult(result);
        assertEquals(result, game.getResult());
    }

    @Test
    public void roundTest() {
        Game game = new Game();
        Byte rounds = 1;

        game.setRound(rounds);
        assertEquals(rounds, game.getRound());
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
        game.setDate(handler.getDateTime());

        LocalDateTime refDate = LocalDateTime.of(year, month, day, hour, minute, second);
        assertEquals(refDate, game.getDate());
    }

    @Test
    public void spectatorTest() {
        Game game = new Game();
        int spectators = 100;

        game.setSpectators(spectators);
        assertEquals(spectators, game.getSpectators());
    }

}
