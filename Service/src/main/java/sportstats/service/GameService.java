/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import sportstats.service.holders.TeamGameWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.handler.DateHandler;
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
import sportstats.service.holders.GameByTeam;
import sportstats.service.util.CalcBiggestGoalDiffBetweenGames;
import sportstats.service.holders.GameWithResult;
import sportstats.service.holders.GameWithoutResult;
import sportstats.service.holders.Matchups;
import sportstats.service.holders.MatchupsWithResult;

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
        Result result = new Result();
        resultRepo.save(result);
        game.setResult(result);
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

    public GameWithResult findBiggestGoalDiff(Long team1Id, Long team2Id, Long seasonId) {
        teamRepo.findById(team2Id).orElseThrow();
        teamRepo.findById(team1Id).orElseThrow();
        seasonRepo.findById(seasonId).orElseThrow();
    
        List<Game> games = gameRepo.listBiggestGoalDiffBySeason(team1Id, team2Id, seasonId);
        CalcBiggestGoalDiffBetweenGames calc = new CalcBiggestGoalDiffBetweenGames();
        Game game =  calc.findBiggestGoalDiff(games);
        GameWithResult gameWResult = new GameWithResult(game);
        return gameWResult; 
    }

    public List<Game> saveAllGames(TeamGameWrapper tgWrap) {
        List<Long> awayTeamId = tgWrap.getAwayTeam();
        List<Game> games = tgWrap.getGame();
        List<Long> homeTeamId = tgWrap.getHomeTeam();
        Long seasonId = tgWrap.getSeasonId();
        Season season = seasonRepo.findById(seasonId).orElseThrow();
        if (!(homeTeamId.size() == awayTeamId.size()) && !(homeTeamId.size() == games.size())) {
            throw new IllegalArgumentException("One of the input lists are out of sync, one list is larger then the other.");
        }
        //Might not be a necessary 
        for (int i = 0; i < games.size(); i++) {
            CheckId.checkId(games.get(i).getId());
        }

        for (int i = 0; i < homeTeamId.size(); i++) {
            if (season.getRoundTot() < games.get(i).getRound()) {
                throw new IllegalArgumentException("Game list index: " + i + " has larger round value then the season round tot.");
            }
            Team homeTeam = teamRepo.findById(homeTeamId.get(i)).orElseThrow();
            Team awayTeam = teamRepo.findById(awayTeamId.get(i)).orElseThrow();
            if (gameRepo.checkIfHomeTeamAlreadyHaveMatchInRound(games.get(i).getRound(), homeTeamId.get(i)) != 0) {
                throw new IllegalArgumentException(homeTeam.getName() + " already exist in this round.");
            }
            if (gameRepo.checkIfAwayTeamAlreadyHaveMatchInRound(games.get(i).getRound(), awayTeamId.get(i)) != 0) {
                throw new IllegalArgumentException(awayTeam.getName() + " already exist in this round.");
            }
            games.get(i).setSeason(season);
            Result result = new Result();
            resultRepo.save(result);
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

    public List<GameWithResult> listMatchesWithResultByRoundAndSeason(byte round, Long seasonId) {
        return gameRepo.listMatchesByRoundAndSeasonId(round, seasonId).stream()
                .map(GameWithResult::new)
                .toList();
    }

    public List<GameWithoutResult> listMatchesWithoutResultByRoundAndSeason(byte round, Long seasonId) {
        return gameRepo.listMatchesByRoundAndSeasonId(round, seasonId).stream()
                .map(GameWithoutResult::new)
                .toList();
    }
    
    public int add(Long gameId, int spectators){
        Game game = gameRepo.getById(gameId);
        game.setSpectators(spectators);
        gameRepo.save(game);
        return game.getSpectators();
    };

    public List<GameWithResult> listMatchesWithResultBySeason(Long seasonId) {
        return gameRepo.listMatchesBySeasonId(seasonId).stream()
                .map(GameWithResult::new)
                .toList();
    }

    public List<GameWithoutResult> listMatchesWithoutResultBySeason(Long seasonId) {
        return gameRepo.listMatchesBySeasonId(seasonId).stream()
                .map(GameWithoutResult::new)
                .toList();
    }

    public List<Matchups> listMatchups(Long teamOneId, Long teamTwoId) {
        List<Game> games = new ArrayList();
        List<Game> game1 = gameRepo.listMatchupHometeamAwayTeam(teamOneId, teamTwoId);
        List<Game> game2 = gameRepo.listMatchupHometeamAwayTeam(teamTwoId, teamOneId);
        games.addAll(game1);
        games.addAll(game2);

        return games.stream().map(Matchups::new).toList();

    }

    public List<MatchupsWithResult> listMatchupsWithResult(Long teamOneId, Long teamTwoId) {
        List<Game> games = new ArrayList();
        List<Game> game1 = gameRepo.listMatchupHometeamAwayTeam(teamOneId, teamTwoId);
        List<Game> game2 = gameRepo.listMatchupHometeamAwayTeam(teamTwoId, teamOneId);
        games.addAll(game1);
        games.addAll(game2);

        return games.stream().map(MatchupsWithResult::new).toList();

    }
    
    public List<Game> getGameByDateAndLeague(Long leagueId, short year, byte month, byte day){
        
        List<Season> seasonByLeague = seasonRepo.listByLeague(leagueId);
        List<Game> gamesBySeason;
        List<Game> gameList = new ArrayList();
        List<Game> gameByDate = new ArrayList();
        
        for (Season season : seasonByLeague) {
            
         gamesBySeason = gameRepo.listMatchesBySeasonId(season.getId());
            
            for (Game game : gamesBySeason) {
                gameList.add(game);
            }
        } 
        
        DateHandler handler = new DateHandler();
        handler.addDate(year, month, day);
        
        for (Game game : gameList) {
            
            gameByDate = gameRepo.listMatchesByDate(handler.getDate(), game.getSeason().getId());
        }
        
       return gameByDate;
    };

}
