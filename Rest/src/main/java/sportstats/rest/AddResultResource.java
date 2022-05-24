/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Game;
import sportstats.service.AddResultService;

/**
 *
 * @author alexf
 */
@RestController
@RequestMapping("addResult")
public class AddResultResource {
    private final AddResultService service;
    
    @Autowired
    public AddResultResource(AddResultService service){
        this.service = service;
    }
    
    @PostMapping("score/{gameId}/{homeTeamScore}/{awayTeamScore}")
    public Game addResultScore(@PathVariable Long gameId, 
            @PathVariable short homeTeamScore, @PathVariable short awayTeamScore){
        
        return service.addResultScore(gameId, homeTeamScore, awayTeamScore);
    }
    
    
    @PostMapping("meta/{gameId}/{overTime}/{endTime}/{penalty}")
    public Game addResultMeta(@PathVariable Long gameId, 
            @PathVariable boolean overTime, @PathVariable Long endTime, 
            @PathVariable boolean penalty){
        
        return service.addResultMeta(gameId, overTime, endTime, penalty);
    }
    
    @PostMapping("all/{gameId}/{homeTeamScore}/{awayTeamScore}/{overTime}/{endTime}/{penalty}")
    public Game addAllData(@PathVariable Long gameId, 
            @PathVariable short homeTeamScore, @PathVariable short awayTeamScore,
            @PathVariable boolean overTime, @PathVariable Long endTime, 
            @PathVariable boolean penalty){
        
        return service.addGameResult(gameId, homeTeamScore, awayTeamScore, overTime, endTime, penalty);
    }
    
    
    
}
