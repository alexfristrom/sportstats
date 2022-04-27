package tests.domain;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import sportstats.domain.League;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Sport;

/**
 *
 * @author David Sjöblom
 */
public class LeagueTest {

    @Test
    public void setAndGetName() {
        var testObject = new League();
        testObject.setName("foobar");
        assertEquals("foobar", testObject.getName());
        assertNotEquals("",testObject.getName());
    }
    
//    @Test
//    public void setAndGetSportId(){
//        var testObject = new League();
//        testObject.setSport(Long.MIN_VALUE);
//        assertEquals(Long.MIN_VALUE,testObject.getSportId());
//        assertNotEquals(Long.MAX_VALUE,testObject.getSportId());
//    }
}
