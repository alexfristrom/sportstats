package tests.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Season;

/**
 * Test for Domain object Season
 * Tests for getters and setters
 * @author alexf
 */
public class SeasonTest {
    
    @Test
    public void spanIdTest(){
        var testSeason = new Season();
        Long testValue = 1L;
        testSeason.setSpanId(testValue);
        assertEquals(testValue, testSeason.getSpanId());
    }
    
    @Test
    public void leagueIdTest(){
        var testSeason = new Season();
        Long testValue = 1L;
        testSeason.setLeagueId(testValue);
        assertEquals(testValue, testSeason.getLeagueId());
    }
    
    @Test
    public void roundTotTest(){
        var testSeason = new Season();
        int testValue = 1;
        testSeason.setRoundTot(testValue);
        assertEquals(testValue, testSeason.getRoundTot());
    }
}
