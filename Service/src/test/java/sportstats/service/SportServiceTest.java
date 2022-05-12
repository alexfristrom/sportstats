/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sportstats.repository.SportRepository;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Sport;
import sportstats.service.util.ListableProxy;

/**
 *
 * @author David Sjöblom
 */
public class SportServiceTest {

    private SportRepository sportRepo;

    SportService sportService;

    private void mockSetup() {
        sportRepo = mock(SportRepository.class);

        sportService = new SportService(sportRepo);
    }
    /**
     * Behaviour test for saveSport.
     */
    @Test
    public void testsaveSport() {
        mockSetup();

        Sport sport = mock(Sport.class);
        Mockito.when(sport.getId()).thenReturn(null);
        Mockito.when(sport.getName()).thenReturn("abc");
        Mockito.when(sportRepo.findByName(sport.getName())).thenReturn(null);
        Mockito.when(sportRepo.save(sport)).thenReturn(sport);
        
        assertTrue(sportService.saveSport(sport) == sport);
    }
    
    @Test
    public void testgetSport(){
        mockSetup();
        
        Sport sport = new Sport();
        Mockito.when(sportRepo.getById(1L)).thenReturn(sport);
        
        assertNotNull(sportService.getSport(1L));
    }
    
    @Test
    public void testgetAllSport(){
        mockSetup();
        
        List<Sport> sport = new ArrayList();
        sport.add(new Sport());
        Mockito.when(sportRepo.findAll()).thenReturn(sport);
        
        assertNotNull(sportService.getAllSport());
    }

}
