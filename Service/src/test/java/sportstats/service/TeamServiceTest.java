/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import sportstats.repository.TeamRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.SportRepository;
import sportstats.domain.Season;
import sportstats.domain.Sport;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Team;
import sportstats.domain.Arena;
import sportstats.service.util.CheckName;

/**
 *
 * @author max
 */
public class TeamServiceTest {

    @Mock

    private TeamRepository teamRep;
    private SportRepository sportRep;
    private SeasonRepository seasonRep;

    TeamService teamService;
    SportService sportService;
    SeasonService seasonService;

    public TeamServiceTest() {
    }

    /**
     * Test of addSeasonToTeam method, of class TeamService.
     */
    @Test
    public void testAddSeasonToTeam() {
        teamRep = mock(TeamRepository.class);
        sportRep = mock(SportRepository.class);
        seasonRep = mock(SeasonRepository.class);
        teamService = new TeamService(teamRep, seasonRep, sportRep);

        System.out.println("addSeasonToTeam");
        Season season = new Season();
        Mockito.when(seasonRep.getById(1L)).thenReturn(season);
        Mockito.when(seasonRep.getById(2L)).thenReturn(season);
        Mockito.when(teamRep.countAllTeamsInSeason(1L)).thenReturn(51);
        Mockito.when(teamRep.countAllTeamsInSeason(2L)).thenReturn(25);

        /*
        Testar funktion utav throw då antalet team per season > 50
         */
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    teamService.addSeasonToTeam("Liverpool", 1L);
                });

        /*
        Testar funktionen av att det läggs till och returnerar en saved season
         */
        Team team = new Team();
        team.setName("Liverpool");
        Mockito.when(teamRep.findByName("Liverpool")).thenReturn(team);
        Mockito.when(teamRep.save(any(Team.class))).thenReturn(team);
        team = teamService.addSeasonToTeam("Liverpool", 2L);
        assertEquals(season, team.getSeason());
    }

    @Test
    public void testCreateTeam() {
        teamRep = mock(TeamRepository.class);
        sportRep = mock(SportRepository.class);
        seasonRep = mock(SeasonRepository.class);
        teamService = new TeamService(teamRep, seasonRep, sportRep);
        Sport sport = new Sport();
        Team team  = new Team();
        Arena arena = new Arena();
        Season season = new Season();
        
        team.setName("Barcelona");
        team.setArena(arena);
        team.setSeason(season);
        Mockito.when(sportRep.getById(1L)).thenReturn(sport);
        Mockito.when(teamRep.save(any(Team.class))).thenReturn(team);
        
        team = teamService.createTeam(1L, team);
        assertEquals("Barcelona", team.getName());
        assertEquals(sport, team.getSport());
        assertEquals(arena, team.getArena());
        assertEquals(season, team.getSeason());
        
    }

}
