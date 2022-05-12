/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sportstats.repository.ArenaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Arena;
import sportstats.domain.Listable;

/**
 *
 * @author max
 */
public class ArenaServiceTest {

    @Mock

    private ArenaRepository arenaRep;

    ArenaService arenaService;

    public ArenaServiceTest() {
    }

    @Test
    public void testSaveArena() {
        arenaRep = mock(ArenaRepository.class);
        arenaService = new ArenaService(arenaRep);
        Arena arena = new Arena();

        Mockito.when(arenaRep.findByName(arena.getName())).thenReturn("Camp Nou");
        Mockito.when(arenaRep.save(any(Arena.class))).thenReturn(arena);

        System.err.println("testSaveArena");
        arena.setName("Camp Nou");

        Arena newArena = arenaService.saveArena(arena);
        assertEquals("Camp Nou", newArena.getName());
    }

    /**
     * Test of getArena method, of class ArenaService.
     */
    @Test
    public void testGetArena() {
        arenaRep = mock(ArenaRepository.class);
        arenaService = new ArenaService(arenaRep);
        Arena arena = new Arena();

        Mockito.when(arenaRep.getById(1L)).thenReturn(arena);
        assertEquals(arena, arenaService.getArena(1L));

    }

    /**
     * Test of getAllArena method, of class ArenaService.
     */
    @Test
    public void testGetAllArena() {
        arenaRep = mock(ArenaRepository.class);
        arenaService = new ArenaService(arenaRep);
        List<Arena> allArena = new ArrayList();
        
        Mockito.when(arenaRep.findAll()).thenReturn(allArena);
        assertEquals(allArena, arenaService.getAllArena());
    }

}
