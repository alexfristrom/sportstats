/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Result;

/**
 *
 * @author David Sjöblom
 */
public class ResultTest {
    
    @Test
    public void setAndGetHometeamScore(){
        var testObject = new Result();
        short shortValue = 2;
        testObject.setHomeTeamScore(shortValue);
        assertEquals(testObject.getHomeTeamScore(), 2);
        assertNotEquals(testObject.getHomeTeamScore(),1);
    }
    
    @Test
    public void setAndGetAwayteam_score(){
        var testObject = new Result();
        short shortValue = 10;
        testObject.setAwayTeamScore(shortValue);
        assertEquals(testObject.getAwayTeamScore(),10);
        assertNotEquals(testObject.getAwayTeamScore(),5); 
    }
    
    @Test
    public void setAndGetOvertime(){
        var testObject = new Result();
        testObject.setOvertime(true);
        assertTrue(testObject.getOvertime());
        testObject.setOvertime(false);
        assertFalse(testObject.getOvertime());
        
    }
    @Test
    public void setAndGetOvertimeMinutes(){
        var testObject = new Result();
        testObject.setOvertimeMinutes(Long.MAX_VALUE);
        assertEquals(testObject.getOvertimeMinutes(),Long.MAX_VALUE);
        assertNotEquals(testObject.getOvertimeMinutes(),Long.MIN_VALUE); 
    }
    
    @Test
    public void setAndGetPenalty(){
        var testObject = new Result();
        testObject.setPenalty(true);
        assertTrue(testObject.getPenalty());
        testObject.setPenalty(false);
        assertFalse(testObject.getPenalty()); 
    }
}
