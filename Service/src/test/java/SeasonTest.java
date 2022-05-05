/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import sportstats.domain.Sport;
import sportstats.repository.SportRepository;
import sportstats.service.SportService;

/**
 *
 * @author alexf
 */
//@RunWith(MockitoJUnitRunner.class)
public class SeasonTest {
    
    @Mock
   
    private SportRepository sportRepository;

    SportService sportService;

    /**
     * Test success of saveSport method, of class SportService.
     */
    @Test
    public void testSaveSportSuccess() {
        sportRepository = mock(SportRepository.class);
        sportService = new SportService(sportRepository);
        
        
        System.out.println("saveSportSuccess");
        Sport sport = new Sport();
        
        sport.setName("Fotboll");
        Mockito.when(sportRepository.save(any(Sport.class))).thenReturn(sport); 

        sportService.saveSport(sport);
        assertEquals("Fotboll", sport.getName());
    }
}
