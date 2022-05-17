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
import sportstats.service.util.GameByTeam;
import sportstats.service.util.GoalDiff;

/**
 *
 * @author annjohansson
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
    
    public List<GameByTeam> listAllByTeam(Long teamId){
        return gameRepo.listAllByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }
    
     public List<GameByTeam> listAwayByTeam(Long teamId){
        return gameRepo.listAwayByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }
     
      public List<GameByTeam> listHomeByTeam(Long teamId){
        return gameRepo.listHomeByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }
//finns ingen felhantering för om lagena existerar innan man skickar hämtar data.
    public Game findGoalDiff(Long team1Id, Long team2Id, Long seasonId) {
     List<Game> games = gameRepo.listDiffBySeason(team1Id, team2Id, seasonId);
     GoalDiff calc = new GoalDiff();
     Game game =  calc.findBiggestGoalDiff(games);
     return game; 
    }
}
