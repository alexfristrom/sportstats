/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Arena;


/**
 *
 * @author David Sjöblom
 */
public class ArenaTest {
    
    @Test
    public void setAndGetName(){
        var testObject = new Arena();
        testObject.setName("foobar");
        assertEquals("foobar",testObject.getName());
        assertNotEquals("",testObject.getName());
    }
    
    @Test
    public void setAndGetCapacity(){
        var testObject = new Arena();
        testObject.setCapacity(Integer.MAX_VALUE);
        assertEquals(testObject.getCapacity(),Integer.MAX_VALUE);
        assertNotEquals(testObject.getCapacity(),0);
    }

}
