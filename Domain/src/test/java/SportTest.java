/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Sport;

/**
 *
 * @author David Sjöblom
 */
public class SportTest {
    
    @Test
    public void setAndGetName(){
        var testObject = new Sport();
        testObject.setName("foobar");
        assertEquals("foobar",testObject.getName());
        assertNotEquals("",testObject.getName());
    }
}
