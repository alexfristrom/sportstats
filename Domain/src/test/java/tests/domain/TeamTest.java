package tests.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Arena;
import sportstats.domain.Season;
import sportstats.domain.Team;

/**
 *
 * @author David Sjöblom
 */
public class TeamTest {

    @Test
    public void setAndSetArenaId() {
        var testObject = new Team();
        Arena arena = new Arena();
        testObject.setArena(arena);
        assertEquals(arena, testObject.getArena());
        assertNotEquals(null, testObject.getArena());
    }

    @Test
    public void setAndGetName() {
        var testObject = new Team();
        testObject.setName("foobar");
        assertEquals("foobar", testObject.getName());
        assertNotEquals("", testObject.getName());
    }

    @Test
    public void setAndGetSeasonId() {
        var testObject = new Team();
        Season season = new Season();
        testObject.setSeason(season);
        assertEquals(season, testObject.getSeason());
        assertNotEquals(null, testObject.getSeason());
    }

}
