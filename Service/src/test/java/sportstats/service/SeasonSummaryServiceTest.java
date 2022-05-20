/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.repository.GameRepository;
import sportstats.repository.TeamRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.service.season.holders.SeasonSumType;

/**
 *
 * @author David Sjöblom
 */
public class SeasonSummaryServiceTest {
    
    private TeamRepository teamRepo;
    private GameRepository gameRepo;
    private SeasonRepository seasonRepo;
    private ResultRepository resultRepo;
    private SeasonSummaryService service;
    public SeasonSummaryServiceTest() {
    }
    private void mockSetupWithoutServiceMock(){
        teamRepo = mock(TeamRepository.class);
        gameRepo = mock(GameRepository.class);
        seasonRepo = mock(SeasonRepository.class);
        resultRepo = mock(ResultRepository.class);
        
        service = new SeasonSummaryService(seasonRepo, teamRepo, gameRepo, resultRepo);
        
    }
    
    @Test
    public void testgetSeasonsSummary(){
        mockSetupWithoutServiceMock();
        
        service.getSeasonsSummary("1,3");
        verify(teamRepo,times(3)).listBySeason(any(Long.class));
    }
}
