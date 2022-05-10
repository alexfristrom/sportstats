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
import sportstats.service.util.GameByTeam;

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
    
    @GetMapping("listAllByTeam/{teamId}")
    public List<GameByTeam> listAllByTeam(@PathVariable Long teamId){
        return service.listAllByTeam(teamId);
    }
        
    @GetMapping("listAwayByTeam/{teamId}")
    public List<GameByTeam> listAwayByTeam(@PathVariable Long teamId){
        return service.listAwayByTeam(teamId);
    }
    
    @GetMapping("listHomeByTeam/{teamId}")
    public List<GameByTeam> listHomeByTeam(@PathVariable Long teamId){
        return service.listHomeByTeam(teamId);
    }
    
//    @PostMapping("/addPlannedMatches/{homeTeam}/{awayTeam}")
//    public List<Game> saveAllGames(@PathVariable List<Long> homeTeam,@PathVariable List<Long> awayTeam
//            ,@RequestBody List<Game> games){
//        return service.saveAllGames(homeTeam,awayTeam,games);
//    }
    
    @PostMapping("/addPlanned/{homeTeamId}/{awayTeamId}/{seasonId}")
    public Game saveAll(@PathVariable Long homeTeamId,@PathVariable Long awayTeamId,@PathVariable Long seasonId ,@RequestBody Game games){
        return service.saveAllGames(homeTeamId, awayTeamId,seasonId,games);
    }
    
//    
//    public class homeWrapper{
//        List<Long> team;
//        
//        public void set(Long homeTeam){
//            this.team.add(homeTeam);
//        }
//        public Long get(int index){
//            return this.team.get(index);
//        }
//    }
//    
//    public class awayWrapper{
//        List<Long> team;
//        public void set(Long awayTeam){
//            this.team.add(awayTeam);
//        }
//        public Long get(int index){
//            return this.team.get(index)
//        }
//    }
}
