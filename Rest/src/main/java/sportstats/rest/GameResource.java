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
import sportstats.service.util.Matchups;
import sportstats.service.util.MatchupsWithResult;

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
    
     @GetMapping("getBiggestGoalDiff/{team1Id}/{team2Id}/{seasonId}")
     public GameWithResult getBiggestGoalDiff(@PathVariable Long team1Id,
             @PathVariable Long team2Id,
             @PathVariable Long seasonId){
         return service.findBiggestGoalDiff(team1Id, team2Id, seasonId);
     }

    @PostMapping("/addPlannedMatches")
    public List<Game> saveAllGames(@RequestBody TeamGameWrapper wrap) {
        return service.saveAllGames(wrap);
    }
    
    @PostMapping("/addSpectators/{gameId}/{spectators}")
    public int addSpectators(@PathVariable Long gameId,@PathVariable int spectators){
        return service.add(gameId, spectators);
    };

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
    
    @GetMapping("listMatchups/{teamOneId}/{teamTwoId}")
    public List<Matchups> listMatchups(@PathVariable Long teamOneId,@PathVariable Long teamTwoId){
        return service.listMatchups(teamOneId,teamTwoId);
    }
    
    @GetMapping("listMatchupsWithResult/{teamOneId}/{teamTwoId}")
    public List<MatchupsWithResult> listMatchupsWithResult(@PathVariable Long teamOneId,@PathVariable Long teamTwoId){
        return service.listMatchupsWithResult(teamOneId, teamTwoId);
    }
    
    @GetMapping("/listGameByDateAndLeague/{year}/{month}/{day}/{leagueId}")
    public List<Game> listGameByDateAndLeague(@PathVariable short year,
            @PathVariable byte month,
            @PathVariable byte day,
            @PathVariable Long leagueId) {
        return service.getGameByDateAndLeague(leagueId, year, month, day);
    }
}
