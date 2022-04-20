/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Team;

/**
 *
 * @author David Sjöblom
 */
public class TeamTest {

    @Test
    public void setAndSetArenaId() {
        var testObject = new Team();
        testObject.setArenaId(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, testObject.getArenaId());
        assertNotEquals(Long.MIN_VALUE, testObject.getArenaId());
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
        testObject.setSeasonId(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, testObject.getSeasonId());
        assertNotEquals(Long.MAX_VALUE, testObject.getSeasonId());
    }

}
