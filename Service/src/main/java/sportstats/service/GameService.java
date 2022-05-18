/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.time.LocalDateTime;
import java.util.Date;
import sportstats.service.util.TeamGameWrapper;
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
    public GameService(GameRepository gameRepository, TeamRepository teamRepository,
             ResultRepository resultRepository, SeasonRepository seasonRepository) {
        this.gameRepo = gameRepository;
        this.teamRepo = teamRepository;
        this.resultRepo = resultRepository;
        this.seasonRepo = seasonRepository;
    }

    public Game saveGame(Game game) {
        return gameRepo.save(game);
    }

    public Game getGame(Long id) {
        return gameRepo.getById(id);
    }

    public List<Game> getAllGame() {
        return gameRepo.findAll();
    }

    public List<GameByTeam> listAllByTeam(Long teamId) {
        return gameRepo.listAllByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }

    public List<GameByTeam> listAwayByTeam(Long teamId) {
        return gameRepo.listAwayByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }

    public List<GameByTeam> listHomeByTeam(Long teamId) {
        return gameRepo.listHomeByTeam(teamId).stream()
                .map(GameByTeam::new)
                .toList();
    }

    public List<Game> saveAllGames(TeamGameWrapper tgWrap) {
        List<Long> awayTeamId = tgWrap.getAwayTeam();
        List<Game> games = tgWrap.getGame();
        List<Long> homeTeamId = tgWrap.getHomeTeam();
        Long seasonId = tgWrap.getSeasonId();
        Result result = new Result();
        resultRepo.save(result);
        Season season = seasonRepo.findById(seasonId).orElseThrow();
        if (!(homeTeamId.size() == awayTeamId.size()) && !(homeTeamId.size() == games.size())) {
            throw new IllegalArgumentException("One of the input lists are out of sync, one list is larger then the other.");
        }
        //Might not be a necessary 
        for (int i = 0; i < games.size(); i++) {
            CheckId.checkId(games.get(i).getId());
        }

        for (int i = 0; i < homeTeamId.size(); i++) {
            if(season.getRoundTot() < games.get(i).getRound()){
                throw new IllegalArgumentException("Game list index: " + i + " has larger round value then the season round tot.");
            }
            Team homeTeam = teamRepo.findById(homeTeamId.get(i)).orElseThrow();
            Team awayTeam = teamRepo.findById(awayTeamId.get(i)).orElseThrow();
            if( gameRepo.checkIfHomeTeamAlreadyHaveMatchInRound(games.get(i).getRound(),homeTeamId.get(i)) != 0){
                throw new IllegalArgumentException(homeTeam.getName() + " already exist in this round.");
            }
            if(gameRepo.checkIfAwayTeamAlreadyHaveMatchInRound(games.get(i).getRound(), awayTeamId.get(i)) != 0){
                throw new IllegalArgumentException(awayTeam.getName() + " already exist in this round.");
            }
            games.get(i).setSeason(season);
            games.get(i).setResult(result);

            String fixedName = CheckName.checkNameContent(homeTeam.getName());
            homeTeam.setName(fixedName);
            fixedName = CheckName.checkNameContent(awayTeam.getName());
            awayTeam.setName(fixedName);
            
            games.get(i).setHomeTeam(homeTeam);
            games.get(i).setAwayTeam(awayTeam);
            
        }
        return gameRepo.saveAll(games);
    }
    
    public int add(Long gameId, int spectators){
        Game game = gameRepo.getById(gameId);
        game.setSpectators(spectators);
        gameRepo.save(game);
        return game.getSpectators();
    };
    
    public List<Game> getGameByDateAndLeague(Long leagueId, LocalDateTime date){
        
        List<Season> seasonsWithLeague = seasonRepo.listByLeague(leagueId);
        List<Game> gamesBySeason;
        List<Game> gameList = null;
        List<Game> gameByDate = null;
        
        for (Season season : seasonsWithLeague) {
            
         gamesBySeason = gameRepo.listMatchesBySeasonId(season.getId());
            
            for (Game listOfGame : gamesBySeason) {
                gameList.add(listOfGame);
            }
        } 
        
        for (Game game : gameList) {
            
            gameByDate = gameRepo.listMatchesByDate(date, game.getSeason().getId());
        }
        
       return gameByDate;
    };

}
