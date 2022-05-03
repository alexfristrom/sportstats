/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import sportstats.domain.Sport;
import sportstats.repository.SportRepository;

/**
 *
 * @author annjohansson
 */
@ExtendWith(MockitoExtension.class)
public class SportServiceTest {
    
    @Mock
    private SportRepository sportRepository;

    SportService sportService;
    
    
    @BeforeEach
    public void setUp() {
        sportService = new SportService(sportRepository);
    }
    
    @AfterEach
    public void tearDown() {
        sportService = null;
    }

    /**
     * Test success of saveSport method, of class SportService.
     */
    @Test
    public void testSaveSportSuccess() {
        System.out.println("saveSportSuccess");
        Sport sport = mock(Sport.class);
        //Sport savedSport = mock(Sport.class);
        sport.setName("Fotboll");
        when(sportRepository.save(any(Sport.class))).thenReturn(sport);
        
        sportService.saveSport(sport);
        assertEquals("Fotboll",sport.getName());
    }

//    /**
//     * Test of getSport method, of class SportService.
//     */
//    @Test
//    public void testGetSport() {
//        System.out.println("getSport");
//        Long id = null;
//        SportService instance = null;
//        Sport expResult = null;
//        Sport result = instance.getSport(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllSport method, of class SportService.
//     */
//    @Test
//    public void testGetAllSport() {
//        System.out.println("getAllSport");
//        SportService instance = null;
//        List<Listable> expResult = null;
//        List<Listable> result = instance.getAllSport();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//   
    
}
