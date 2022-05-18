/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.repository.GameRepository;

/**
 *
 * @author alexf
 */
@Service
public class AddResultService {
    
    private GameRepository gameR;
    
    @Autowired
    public AddResultService(GameRepository gameRepository){
        this.gameR = gameRepository;
    }
    
    public Game addResultScore(Long gameId, int homeTeamScore, int awayTeamScore){  
        Game game = gameR.getById(gameId);
        Result result = game.getResult();
        
        result.setHomeTeamScore(homeTeamScore);
        result.setAwayTeamScore(awayTeamScore);
        
        game.setResult(result);
        gameR.save(game);
        
        return game;
    }
    
    public Game addResultMeta(Long gameId, boolean overtime, Long endTime, 
            boolean penalty){
        
        Game game = gameR.getById(gameId);
        Result result = game.getResult();
        
        result.setOvertime(overtime);
        result.setOvertimeMinutes(endTime);
        result.setPenalty(penalty);
        
        game.setResult(result);
        gameR.save(game);
        
        return game;
    }
    
    
    public Game addGameResult(Long gameId, int homeTeamScore, int awayTeamScore, 
            boolean overtime, Long endTime, boolean penalty){
        
        Game game = gameR.getById(gameId);
        Result result = game.getResult();
        
        result.setHomeTeamScore(homeTeamScore);
        result.setAwayTeamScore(awayTeamScore);
        result.setOvertime(overtime);
        result.setOvertimeMinutes(endTime);
        result.setPenalty(penalty);
        
        game.setResult(result);
        gameR.save(game);
        
        return game;
    }
    
}
