/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import sportstats.service.util.TeamGameWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Game;
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
        List<Long> awayTeam = tgWrap.getAwayTeam();
        List<Game> games = tgWrap.getGame();
        List<Long> homeTeam = tgWrap.getHomeTeam();
        Long seasonId = tgWrap.getSeasonId();
        Season season = seasonRepo.findById(seasonId).orElseThrow();
        if (!(homeTeam.size() == awayTeam.size()) && !(homeTeam.size() == games.size())) {
            throw new IllegalArgumentException("One of the input lists are out of sync, one list is larger then the other.");
        }
        //Might not be a necessary 
        for (int i = 0; i < games.size(); i++) {
            CheckId.checkId(games.get(i).getId());
        }

        for (int i = 0; i < homeTeam.size(); i++) {
            if(season.getRoundTot() < games.get(i).getRound()){
                throw new IllegalArgumentException("Game list index: " + i + " has illegal round value, can't be above 50.(Hardcoded)");
            }
            games.get(i).setSeason(season);
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

}
