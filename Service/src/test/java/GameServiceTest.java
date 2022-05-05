/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sportstats.domain.Game;

import sportstats.repository.GameRepository;
import sportstats.service.GameService;

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

}
