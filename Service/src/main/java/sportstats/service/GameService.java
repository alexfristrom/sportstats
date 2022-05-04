/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Game;
import sportstats.repository.GameRepository;

/**
 *
 * @author David Sjöblom
 */
@Service
public class GameService {
    private final GameRepository gameRepo;
    
    @Autowired
    public GameService(GameRepository gameRepository){
        this.gameRepo = gameRepository;
    }
    
    public Game saveGame(Game game){
        return gameRepo.save(game);
    }

    public Game getGame(Long id) {
        return gameRepo.getById(id);
    }
    
    public List<Game> getAllGame(){
        return gameRepo.findAll();
    }
}
