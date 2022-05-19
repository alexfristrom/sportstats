/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Result;
import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;
import sportstats.service.util.GameResultByTeam;

/**
 *
 * @author annjohansson
 */
@Service
public class ResultService {

    private final ResultRepository Repo;
    private final GameRepository gameRepo;

    
    @Autowired
    public ResultService(ResultRepository Repo, GameRepository gameRepo) {
        this.Repo = Repo;
        this.gameRepo = gameRepo;
    }
    
    public ResultService(ResultRepository Repo) {
        this.Repo = Repo;
        this.gameRepo = null;
    }
    
    

    public Result saveResult(Result result) {
        return Repo.save(result);
    }

    public Result getResult(Long id) {
        return Repo.getById(id);
    }

    public List<Result> getAllResult() {
        return Repo.findAll();
    }
    
    public List<Result> getTeamResults(Long teamId, String winCondition){
        GameResultByTeam teamResults = new GameResultByTeam(gameRepo, Repo);
        return teamResults.getTeamGamesResult(teamId, winCondition);
    }
    
}
