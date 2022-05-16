/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Game;
import sportstats.service.GameService;

/**
 *
 * @author annjohansson
 */
@RestController
@RequestMapping("stats")
public class StatResource {
    private final GameService gameService;
    
    @Autowired
    public StatResource(GameService gameService){
        this.gameService = gameService;
    }
    
     @GetMapping("getGoalDiff/{team1Id}/{team2Id}/{seasonId}")
     public Game getGoalDiff(@PathVariable Long team1Id,
             @PathVariable Long team2Id,
             @PathVariable Long seasonId){
         return gameService.getGoalDiff(team1Id, team2Id, seasonId);
         
     }
}
