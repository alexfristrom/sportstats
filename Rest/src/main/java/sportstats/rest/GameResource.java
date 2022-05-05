/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Game;
import sportstats.service.GameService;

/**
 *
 * @author annjohansson
 */
@RestController
@RequestMapping("game")
public class GameResource {
      private final GameService service;

    @Autowired
    public GameResource(GameService service){
        this.service = service;
    }

    
    @PostMapping
    public Game saveGame(@RequestBody Game game){
        return service.saveGame(game);
    }

    @GetMapping("{id}")
    public Game getGameById(@PathVariable Long id){
        return service.getGame(id);
    }

    @GetMapping
    public List<Game> getAllGame(){
        return service.getAllGame();
    }
}
