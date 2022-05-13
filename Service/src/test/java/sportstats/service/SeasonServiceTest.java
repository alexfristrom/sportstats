/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Season;
import sportstats.service.util.SeasonByLeague;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Result;
import static org.mockito.ArgumentMatchers.any;
import sportstats.domain.League;
import sportstats.domain.Span;
import sportstats.repository.LeagueRepository;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.SpanRepository;

/**
 *
 * @author max
 */
public class SeasonServiceTest {

    @Mock

    private SeasonRepository seasonRep;
    private LeagueRepository leagueRep;
    private SpanRepository spanRep;

    SeasonService seasonService;

    public SeasonServiceTest() {
    }

    /**
     * Test of saveSeason method, of class SeasonService.
     */
    @Test
    public void testSaveSeason() {
        leagueRep = mock(LeagueRepository.class);
        seasonRep = mock(SeasonRepository.class);
        spanRep = mock(SpanRepository.class);

        League league = new League();
        Span span = new Span();
        Season season = new Season();

        season.setLeague(league);
        season.setRoundTot(0);
        season.setSpan(span);

        Mockito.when(leagueRep.getById(1L)).thenReturn(league);
        Mockito.when(spanRep.getById(1L)).thenReturn(span);
        Mockito.when(seasonRep.save(any(Season.class))).thenReturn(season);

        seasonService = new SeasonService(leagueRep,
                seasonRep, spanRep);

        Season newSeason = seasonService.saveSeason(0, 1L, 1L);

        assertEquals(season, newSeason);
    }

    /**
     * Test of listByLeague method, of class SeasonService.
     */
    @Test
    public void testListByLeague() {
        leagueRep = mock(LeagueRepository.class);
        seasonRep = mock(SeasonRepository.class);
        spanRep = mock(SpanRepository.class);

        List<SeasonByLeague> seasonList = new ArrayList();

        Mockito.when(seasonRep.listByLeague(1L).stream()
                .map(SeasonByLeague::new)
                .toList()).thenReturn(seasonList);

        seasonService = new SeasonService(leagueRep,
                seasonRep, spanRep);

        List<SeasonByLeague> newSeasonList
                = seasonService.listByLeague(1L);
        
        assertEquals(seasonList, newSeasonList);
        

    }

    /**
     * Test of getAllSeason method, of class SeasonService.
     */
    @Test
    public void testGetAllSeason() {
        leagueRep = mock(LeagueRepository.class);
        seasonRep = mock(SeasonRepository.class);
        spanRep = mock(SpanRepository.class);

        seasonService = new SeasonService(leagueRep,
                seasonRep, spanRep);
        
        List<Season> seasonList = new ArrayList();
        
        Mockito.when(seasonRep.findAll()).thenReturn(seasonList);
        
        List<Season> newSeasonList = seasonService.getAllSeason();
        
        assertEquals(seasonList, newSeasonList);
    }

}
