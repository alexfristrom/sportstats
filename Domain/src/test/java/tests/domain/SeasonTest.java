package tests.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.League;
import sportstats.domain.Season;
import sportstats.domain.Span;

/**
 * Test for Domain object Season
 * Tests for getters and setters
 * @author alexf
 */
public class SeasonTest {
    
    @Test
    public void getAndSetSpanTest(){
        var testSeason = new Season();
        Span span = new Span();
        testSeason.setSpan(span);
        assertEquals(span, testSeason.getSpan());
    }
    
    @Test
    public void getAndSetLeagueTest(){
        var testSeason = new Season();
        League league = new League();
        testSeason.setLeague(league);
        assertEquals(league, testSeason.getLeague());
    }
    
    @Test
    public void roundTotTest(){
        var testSeason = new Season();
        int testValue = 1;
        testSeason.setRoundTot(testValue);
        assertEquals(testValue, testSeason.getRoundTot());
    }
}
