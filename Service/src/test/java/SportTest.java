/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import sportstats.domain.Listable;

import sportstats.domain.Sport;
import sportstats.repository.SportRepository;
import sportstats.service.SportService;

/**
 *
 * @author alexf
 */
//@RunWith(MockitoJUnitRunner.class)
public class SportTest {
    
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

        Sport newSport = sportService.saveSport(sport);
        assertEquals("Fotboll", newSport.getName());
    }
    
    @Test
    public void testGetSport(){
        System.out.println("GetSportTestS");
        sportRepository = mock(SportRepository.class);
        sportService = new SportService(sportRepository);
        
        Long id = 1l;
        Sport sport = new Sport(id, "Testname");
        Mockito.when(sportRepository.getById(id)).thenReturn(sport);
        
        Sport methodSport = sportService.getSport(id);
        
        assertEquals("Testname", methodSport.getName());
        assertEquals(id, methodSport.getId());
        
    }
    
    @Test
    public void testGetAllSport(){
        System.out.println("GetAllSportTest");
        sportRepository = mock(SportRepository.class);
        sportService = new SportService(sportRepository);
        
        Long id = 1l;
        String name = "testname";
        Sport sport = new Sport(id, name);
        List<Sport> sportList = new ArrayList<>();
        sportList.add(sport);
        
        Mockito.when(sportRepository.findAll()).thenReturn(sportList);
        List<Listable> newList = sportService.getAllSport();
         
        assertEquals(id, newList.get(0).getId());
        assertEquals(name, newList.get(0).getName());
    }
}
