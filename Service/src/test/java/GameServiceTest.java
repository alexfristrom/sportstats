/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Game;

import sportstats.repository.GameRepository;
import sportstats.service.GameService;
import sportstats.service.util.GameByTeam;

/**
 *
 * @author David Sjöblom
 */
public class GameServiceTest {

    private GameRepository gameRepository;

    GameService gameService;

    private void mockSetup() {
        gameRepository = mock(GameRepository.class);
        gameService = new GameService(gameRepository);
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

        game.setSpectators(2L);
        game2.setSpectators(3L);

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

        game.setSpectators(2L);
        game2.setSpectators(3L);

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

        game.setSpectators(2L);
        game2.setSpectators(3L);

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

}
