/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Team;
import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.TeamRepository;

/**
 *
 * @author alexf
 */
public class SeasonSummaryService {

    private SeasonRepository seasonR;
    private TeamRepository teamR;
    private GameRepository gameR;
    private ResultRepository resultR;

    public SeasonSummaryService() {
        List<Team> teamList = getAllTeamsInSeason(22L);
        for (Team team : teamList) {
            Long teamId = team.getId();
            String name = team.getName();

            List<Game> gameList = getAllGamesForTeam(teamId);

            calculateTeamGames(gameList, teamId, name);

        }
    }

    public SeasonSummaryService(SeasonRepository season, TeamRepository team, GameRepository game, ResultRepository result) {
        this.seasonR = season;
        this.teamR = team;
        this.gameR = game;
        this.resultR = result;
    }

    private List<Team> getAllTeamsInSeason(Long seasonId) {
        List<Team> listOfTeams = teamR.listBySeason(seasonId);
        return listOfTeams;
    }

    private List<Game> getAllGamesForTeam(Long teamId) {
        return gameR.listAllByTeam(teamId);
    }

//    private Result getResultForGamesByTeams(Long resultId) {
//        return resultR.getById(resultId);
//    }

    private void calculateTeamGames(List<Game> gameList, Long teamID, String teamName) {
        var listOfGame = gameList;
        int numberOfGamesm = listOfGame.size();

        String teamN = teamName;
        int gamesWon = 0;
        int gamesTied = 0;
        int gamesLost = 0;

        int scoredGoals = 0;
        int concededGoals = 0;
        int goalDiff = 0;

        for (Game game : listOfGame) {
            Long gameId = game.getId();

            Result tempReult = game.getResult();

            Long teamScore = null;
            Long otherTeamScore = null;

            if (game.getHomeTeam().getId() == teamID) {
                teamScore = tempReult.getHomeTeamScore();
                otherTeamScore = tempReult.getAwayTeamScore();
                scoredGoals += teamScore;
                concededGoals += otherTeamScore;
            } else {
                teamScore = tempReult.getAwayTeamScore();
                otherTeamScore = tempReult.getHomeTeamScore();
                scoredGoals += teamScore;
                concededGoals += otherTeamScore;
            }

            if (teamScore > otherTeamScore) {
                gamesWon++;

            } else if (teamScore == otherTeamScore) {
                gamesTied++;

            } else {
                gamesLost++;
            }
        }
        goalDiff = scoredGoals - concededGoals;

    }

}
