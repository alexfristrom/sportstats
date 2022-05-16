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
import sportstats.service.util.TeamGameWrapper;
import sportstats.service.util.GameByTeam;
import sportstats.service.util.GameWithResult;
import sportstats.service.util.GameWithoutResult;

/**
 *
 * @author annjohansson
 */
@RestController
@RequestMapping("game")
public class GameResource {

    private final GameService service;

    @Autowired
    public GameResource(GameService service) {
        this.service = service;
    }

    @PostMapping
    public Game saveGame(@RequestBody Game game) {
        return service.saveGame(game);
    }

    @GetMapping("{id}")
    public Game getGameById(@PathVariable Long id) {
        return service.getGame(id);
    }

    @GetMapping
    public List<Game> getAllGame() {
        return service.getAllGame();
    }

    @GetMapping("listAllByTeam/{teamId}")
    public List<GameByTeam> listAllByTeam(@PathVariable Long teamId) {
        return service.listAllByTeam(teamId);
    }

    @GetMapping("listAwayByTeam/{teamId}")
    public List<GameByTeam> listAwayByTeam(@PathVariable Long teamId) {
        return service.listAwayByTeam(teamId);
    }

    @GetMapping("listHomeByTeam/{teamId}")
    public List<GameByTeam> listHomeByTeam(@PathVariable Long teamId) {
        return service.listHomeByTeam(teamId);
    }

    @PostMapping("/addPlannedMatches")
    public List<Game> saveAllGames(@RequestBody TeamGameWrapper wrap) {
        return service.saveAllGames(wrap);
    }
    
    @GetMapping("listMatchesWithResultByRoundAndSeason/{round}/{seasonId}")
    public List<GameWithResult> listMatchesWithResultByRoundAndSeason(@PathVariable byte round
                                                ,@PathVariable Long seasonId){
        return service.listMatchesWithResultByRoundAndSeason(round,seasonId);
    }
    
    @GetMapping("listMatchesWithoutResultByRoundAndSeason/{round}/{seasonId}")
    public List<GameWithoutResult> listMatchesWithoutByRoundAndSeason(@PathVariable byte round
                                                ,@PathVariable Long seasonId){
        return service.listMatchesWithoutResultByRoundAndSeason(round,seasonId);
    }
    
    @GetMapping("listMatchesWithResultBySeason/{seasonId}")
    public List<GameWithResult> listMatchesWithResultBySeason(@PathVariable Long seasonId){
        return service.listMatchesWithResultBySeason(seasonId);
    }
    
    @GetMapping("listMatchesWithoutResultBySeason/{seasonId}")
    public List<GameWithoutResult> listMatchesWIthoutResultBySeason(@PathVariable Long seasonId){
        return service.listMatchesWithoutResultBySeason(seasonId);
    }
}
