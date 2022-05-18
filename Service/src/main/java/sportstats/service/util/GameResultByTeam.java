/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;

/**
 *
 * @author daniel
 */
public class GameResultByTeam {

    String resultCondition;

    GameRepository gameR;
    ResultRepository resultR;

    @Autowired
    public GameResultByTeam(GameRepository game, ResultRepository result) {
        this.gameR = game;
        this.resultR = result;
    }

    public List<Result> getTeamGamesResult(Long teamId, String g) {
        this.resultCondition = g;
        List<Game> listOfTeamGames = gameR.listAllByTeam(teamId);
        List<Result> listOfTeamGamesResult = null;
        for (Game game : listOfTeamGames) {
            Result result = game.getResult();
            Game currGame = game;
            if (resultCondition.equalsIgnoreCase("win")) {
                if (currGame.getHomeTeam().getId().equals(teamId) && result.getHomeTeamScore() > result.getAwayTeamScore()) {
                    listOfTeamGamesResult.add(result);
                } else if (currGame.getAwayTeam().getId().equals(teamId) && result.getAwayTeamScore() > result.getHomeTeamScore()) {
                    listOfTeamGamesResult.add(result);
                }
            } else if (resultCondition.equalsIgnoreCase("tie")) {
                if (result.getHomeTeamScore() == result.getAwayTeamScore()) {
                    listOfTeamGamesResult.add(result);
                }
            }else if(resultCondition.equalsIgnoreCase("loss")){
                if (currGame.getHomeTeam().getId().equals(teamId) && result.getHomeTeamScore() < result.getAwayTeamScore()) {
                    listOfTeamGamesResult.add(result);
                } else if (currGame.getAwayTeam().getId().equals(teamId) && result.getAwayTeamScore() < result.getHomeTeamScore()) {
                    listOfTeamGamesResult.add(result);
                }
            }

        }
            return listOfTeamGamesResult;
    }
}
