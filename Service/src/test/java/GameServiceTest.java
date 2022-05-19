/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Season;
import sportstats.domain.Team;

import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.TeamRepository;
import sportstats.service.GameService;
import sportstats.service.util.CalcBiggestGoalDiffBetweenGames;
import sportstats.service.util.GameByTeam;
import sportstats.service.util.GameWithResult;
import sportstats.service.util.TeamGameWrapper;

/**
 *
 * @author David Sjöblom
 */
public class GameServiceTest {

    private GameRepository gameRepository;
    private TeamRepository teamRepository;
    private ResultRepository resultRepository;
    private SeasonRepository seasonRepository;
    GameService gameService;

    private void mockSetup() {
        gameRepository = mock(GameRepository.class);
        teamRepository = mock(TeamRepository.class);
        resultRepository = mock(ResultRepository.class);
        seasonRepository = mock(SeasonRepository.class);
        gameService = new GameService(gameRepository, teamRepository,
                resultRepository, seasonRepository);
    }

    /**
     * Test success of saveGame method, of class GameService.
     */
    @Test
    public void testGameSport() {
        mockSetup();

        Game game = new Game();

        Mockito.when(gameRepository.save(any(Game.class))).thenReturn(game);

        assertEquals(gameService.saveGame(game), game);
    }

    /**
     * Testing behaviour of getGame method in GameService
     */
    @Test
    public void testGetGame() {
        mockSetup();

        Game game = new Game();

        Mockito.when(gameRepository.getById(1L)).thenReturn(game);
        assertTrue(gameService.getGame(1L) == game);
    }

    /**
     * Testing behaviour of getAllGame method in GameService
     */
    @Test
    public void testGetAllGame() {
        mockSetup();
        Game game = new Game();
        Game game2 = new Game();
        List<Game> gameList = new ArrayList();
        gameList.add(game);
        gameList.add(game2);
        Mockito.when(gameRepository.findAll()).thenReturn(gameList);

        assertTrue(gameService.getAllGame().get(0) == game);
        assertTrue(gameService.getAllGame().get(1) == game2);

    }

    /**
     * Testing behaviour of listAllByTeam method in GameService
     */
    @Test
    public void testlistAllByTeam() {
        mockSetup();
        Game game = new Game();
        Game game2 = new Game();

        game.setSpectators(1000);
        game2.setSpectators(2000);

        List<Game> gameList = new ArrayList();
        gameList.add(game);
        gameList.add(game2);
        Long id = 1L;

        Mockito.when(gameRepository.listAllByTeam(id)).thenReturn(gameList);
        List<GameByTeam> result = gameService.listAllByTeam(id);
        assertFalse(result.isEmpty());
        assertEquals(game.getSpectators(), result.get(0).getSpectators());
        assertEquals(game2.getSpectators(), result.get(1).getSpectators());

    }

    /**
     * Testing behaviour of listAwayByTeam method in GameService
     */
    @Test
    public void testlistAwayByTeam() {
        mockSetup();
        Game game = new Game();
        Game game2 = new Game();

        game.setSpectators(1000);
        game2.setSpectators(2000);

        List<Game> gameList = new ArrayList();
        gameList.add(game);
        gameList.add(game2);
        Long id = 1L;

        Mockito.when(gameRepository.listAwayByTeam(id)).thenReturn(gameList);

        List<GameByTeam> result = gameService.listAwayByTeam(id);
        assertFalse(result.isEmpty());
        assertEquals(game.getSpectators(), result.get(0).getSpectators());
        assertEquals(game2.getSpectators(), result.get(1).getSpectators());

    }

    /**
     * Testing behaviour of listHomeByTeam method in GameService
     */
    @Test
    public void testlistHomeByTeam() {
        mockSetup();
        Game game = new Game();
        Game game2 = new Game();

        game.setSpectators(1000);
        game2.setSpectators(2000);

        List<Game> gameList = new ArrayList();
        gameList.add(game);
        gameList.add(game2);
        Long id = 1L;

        Mockito.when(gameRepository.listHomeByTeam(id)).thenReturn(gameList);
        List<GameByTeam> result = gameService.listHomeByTeam(id);
        assertFalse(result.isEmpty());
        assertEquals(game.getSpectators(), result.get(0).getSpectators());
        assertEquals(game2.getSpectators(), result.get(1).getSpectators());

    }

    /**
     * Behaviour test for saveAllGames method.
     */
    @Test
    public void testsaveAllGames() {
        mockSetup();

        Result result = new Result();
        Season season = mock(Season.class);
        Team homeTeam = new Team();
        Team awayTeam = new Team();
        homeTeam.setName("adc");
        awayTeam.setName("cba");
        List<Long> homeTeams = new ArrayList();
        List<Long> awayTeams = new ArrayList();
        homeTeams.add(1L);
        homeTeams.add(2L);
        awayTeams.add(2L);
        awayTeams.add(1L);
        Game game1 = new Game();
        game1.setRound(Byte.valueOf("1"));
        Game game2 = new Game();
        game2.setRound(Byte.valueOf("2"));
        int roundTot = 5;
        List<Game> games = new ArrayList();
        games.add(game1);
        games.add(game2);

        Mockito.when(resultRepository.save(any(Result.class))).thenReturn(result);
        Mockito.when(seasonRepository.findById(1L)).thenReturn(Optional.of(season));
        Mockito.when(season.getRoundTot()).thenReturn(roundTot);
        Mockito.when(teamRepository.findById(1L)).thenReturn(Optional.of(homeTeam));
        Mockito.when(teamRepository.findById(2L)).thenReturn(Optional.of(awayTeam));
        Mockito.when(gameRepository.checkIfHomeTeamAlreadyHaveMatchInRound(any(Byte.TYPE), any(Long.TYPE))).thenReturn(0);
        Mockito.when(gameRepository.checkIfAwayTeamAlreadyHaveMatchInRound(any(Byte.TYPE), any(Long.TYPE))).thenReturn(0);
        Mockito.when(gameRepository.saveAll(any(List.class))).thenReturn(games);

        TeamGameWrapper tgWrap = new TeamGameWrapper();
        tgWrap.setAwayTeam(awayTeams);
        tgWrap.setGame(games);
        tgWrap.setHomeTeam(homeTeams);
        tgWrap.setSeasonId(1L);
        assertNotNull(gameService.saveAllGames(tgWrap));

        homeTeams.remove(1);

        assertThrows(IllegalArgumentException.class, () -> {
            gameService.saveAllGames(tgWrap);
        });

        homeTeams.add(2L);
        game1.setRound(Byte.MAX_VALUE);
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.saveAllGames(tgWrap);
        });

        Mockito.when(gameRepository.checkIfHomeTeamAlreadyHaveMatchInRound(any(Byte.TYPE), any(Long.TYPE))).thenReturn(1);
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.saveAllGames(tgWrap);
        });

        Mockito.when(gameRepository.checkIfHomeTeamAlreadyHaveMatchInRound(any(Byte.TYPE), any(Long.TYPE))).thenReturn(0);
        Mockito.when(gameRepository.checkIfAwayTeamAlreadyHaveMatchInRound(any(Byte.TYPE), any(Long.TYPE))).thenReturn(1);
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.saveAllGames(tgWrap);
        });
        

    }
    @Test
    public void testAddSpectator(){
        mockSetup();
        Game game = new Game();
        Mockito.when(gameRepository.getById(1L)).thenReturn(game);
        Mockito.when(gameRepository.save(any(Game.class))).
                thenReturn(game);
        game.setSpectators(34000);
        assertEquals(game.getSpectators(),
                gameService.add(1L, 34000));
    }
    
    /**
     * 
     */
    @Test
    public void testFindBiggestGoalDiff(){
        mockSetup();
        Game game1 = new Game();
        Game game2 = new Game();
        game1.setSpectators(1000);
        game2.setSpectators(2000);
        Result result1 = new Result();
        Result result2 = new Result();
        game1.setResult(result1);
        game2.setResult(result2);
        result1.setHomeTeamScore(1);
        result2.setHomeTeamScore(0);
        result1.setAwayTeamScore(1);
        result2.setAwayTeamScore(4);
        
        List<Game> games = new ArrayList();
        games.add(game1);
        games.add(game2);
        
        Team team1 = new Team();
        Team team2 = new Team();
        
        Season season1 = new Season();
        
        CalcBiggestGoalDiffBetweenGames calc = mock(CalcBiggestGoalDiffBetweenGames.class);
        GameWithResult gameWResult = mock(GameWithResult.class);
        GameWithResult result;
        
        Mockito.when(gameRepository.listBiggestGoalDiffBySeason
        (Long.MIN_VALUE, Long.MAX_VALUE, Long.MIN_VALUE)).thenReturn(games);
        Mockito.when(calc.findBiggestGoalDiff(games)).thenReturn(game2);
        Mockito.when(gameWResult.getSpectators()).thenReturn(2000);
        Mockito.when(teamRepository.findById(Long.MIN_VALUE)).thenReturn(Optional.of(team1));
        Mockito.when(teamRepository.findById(Long.MAX_VALUE)).thenReturn(Optional.of(team2));
        Mockito.when(seasonRepository.findById(Long.MIN_VALUE)).thenReturn(Optional.of(season1));
       
        
        result = gameService.findBiggestGoalDiff(Long.MIN_VALUE, Long.MAX_VALUE, Long.MIN_VALUE);
        
        assertEquals(gameWResult.getSpectators(), result.getSpectators());
    }
    
            

}
