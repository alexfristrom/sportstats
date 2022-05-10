/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Season;
import sportstats.domain.Team;
import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.TeamRepository;
import sportstats.service.util.CheckId;
import sportstats.service.util.CheckName;
import sportstats.service.util.GameByTeam;

/**
 *
 * @author annjohansson
 */
@Service
public class GameService {
    private final GameRepository gameRepo;
    private final TeamRepository teamRepo;
    private final ResultRepository resultRepo;
    private final SeasonRepository seasonRepo;
    @Autowired
    public GameService(GameRepository gameRepository,TeamRepository teamRepository
                        ,ResultRepository resultRepository,SeasonRepository seasonRepository){
        this.gameRepo = gameRepository;
        this.teamRepo = teamRepository;
        this.resultRepo = resultRepository;
        this.seasonRepo = seasonRepository;
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
      
      public List<Game> saveAllGames(List<Long> homeTeam,List<Long> awayTeam,List<Game> games){
        if(homeTeam.size() == awayTeam.size() && homeTeam.size() == games.size())
            throw new IllegalArgumentException("One of the input lists are out of sync, one list is larger then the other.");
        
        for(int i = 0;i < games.size();i++)
            CheckId.checkId(games.get(i).getId());
        
        for(int i = 0;i < homeTeam.size();i++){
            Team homTeam = teamRepo.findById(homeTeam.get(i)).orElseThrow();        
            Team awaTeam = teamRepo.findById(awayTeam.get(i)).orElseThrow();
            String fixedName = CheckName.checkNameContent(homTeam.getName());
            homTeam.setName(fixedName);
            fixedName = CheckName.checkNameContent(awaTeam.getName());
            awaTeam.setName(fixedName);

            games.get(i).setHomeTeam(homTeam);
            games.get(i).setAwayTeam(awaTeam);
        }
          return gameRepo.saveAll(games);
      }
      //Kan mata in en match, problem dock med att mata in som listor i överstående metod.
      //Eventuellt enbart låter det var apå detta vis.
       public Game saveAllGames(Long homeTeamId,Long awayTeamId,Long seasonId,Game games){
            Season season = seasonRepo.findById(seasonId).orElseThrow();
            if(season.getRoundTot() < games.getRound()){
                throw new IllegalArgumentException("Round is above maximum round for the season(Current default value is 50).");
            }
            Team homeTeam = teamRepo.findById(homeTeamId).orElseThrow();        
            Team awayTeam = teamRepo.findById(awayTeamId).orElseThrow();
            if(gameRepo.checkIfHomeTeamAlreadyHaveMatchInRound(games.getRound(), homeTeamId) > 0)
                throw new IllegalArgumentException(homeTeam.getName() + " already have a match in this round.");
            if(gameRepo.checkIfAwayTeamAlreadyHaveMatchInRound(games.getRound(), awayTeamId) > 0)
                throw new IllegalArgumentException(awayTeam.getName() + " arleady have a match in this round.");
            games.setSeason(season);
            games.setHomeTeam(homeTeam);
            games.setAwayTeam(awayTeam);
            Result result = resultRepo.save(new Result());
            games.setResult(result);
            return gameRepo.save(games);
       }
       
       //TODO Testing for saveAllGames function and confirm current solution with the team.
}
