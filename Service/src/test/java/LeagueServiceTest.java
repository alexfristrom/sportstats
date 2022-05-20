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
import sportstats.domain.League;
import sportstats.domain.Listable;
import sportstats.domain.Sport;
import sportstats.repository.LeagueRepository;
import sportstats.repository.SportRepository;
import sportstats.service.LeagueService;
import sportstats.service.holders.LeagueBySport;

/**
 * Test for League service
 *
 * @author alexf
 */
public class LeagueServiceTest {

    @Mock

    private LeagueRepository leagueRepository;

    @Mock

    private SportRepository sportRepository;

    LeagueService leagueService;

    
    @Test
    public void testaveLeague() {
        leagueRepository = mock(LeagueRepository.class);
        sportRepository = mock(SportRepository.class);
        leagueService = new LeagueService(leagueRepository, sportRepository);

        String name = "Test";
        String name2 = "Test2";
        
        Sport sport = new Sport();
        sport.setName(name);
        
        League league = new League();
        league.setName(name2);
        league.setSport(sport);
        
        Mockito.when(sportRepository.getById(1l)).thenReturn(sport);
        Mockito.when(leagueRepository.save(any(League.class))).thenReturn(league);
        
        League newLeague = leagueService.saveLeague(1l, name2);
        assertEquals(name2, newLeague.getName());
        assertEquals(name, newLeague.getSport().getName());
        
    }

    @Test
    public void testListBySport() {
        leagueRepository = mock(LeagueRepository.class);
        sportRepository = mock(SportRepository.class);
        leagueService = new LeagueService(leagueRepository, sportRepository);
        
        String leagueName = "test";
        String leagueName2 = "test2";
        Long id = 1L;
        
        Sport sport1 = new Sport(1L, "sportTest");
        Sport sport2 = new Sport(2L, "sportTest2");
        
        League league1 = new League(sport1);
        league1.setName(leagueName);
        
        League league2 = new League(sport2);
        league2.setName(leagueName2);
        
        List<League> list = new ArrayList<>();
        list.add(league1);
        list.add(league2);
        
        Mockito.when(leagueRepository.listBySport(id)).thenReturn(list);
        List<LeagueBySport> listLbs = leagueService.listBySport(id);
        
        assertEquals(leagueName, listLbs.get(0).getLeagueName());
        assertEquals(leagueName2, listLbs.get(1).getLeagueName());
        
    }

    @Test
    public void testGetAllLeague() {
        leagueRepository = mock(LeagueRepository.class);
        sportRepository = mock(SportRepository.class);
        leagueService = new LeagueService(leagueRepository, sportRepository);

        String leagueName = "test";
        String leagueName2 = "test2";
        Long id = 1L;
        
        Sport sport1 = new Sport(1L, "sportTest");
        Sport sport2 = new Sport(2L, "sportTest2");
        
        League league1 = new League(sport1);
        league1.setName(leagueName);
        
        League league2 = new League(sport2);
        league2.setName(leagueName2);
        
        List<League> list = new ArrayList<>();
        list.add(league1);
        list.add(league2);
        
        Mockito.when(leagueRepository.findAll()).thenReturn(list);
        
        List<Listable> resultList = leagueService.getAllLeague();
        assertEquals(league1.getName(), resultList.get(0).getName());
        assertEquals(league2.getName(), resultList.get(1).getName());
        
    }

}
