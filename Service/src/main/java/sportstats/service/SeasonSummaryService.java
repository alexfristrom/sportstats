/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Team;
import sportstats.repository.GameRepository;
import sportstats.repository.ResultRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.TeamRepository;
import sportstats.service.season.holders.SeasonSumType;
import sportstats.service.season.holders.Summary;
import sportstats.service.season.holders.SummaryWithOvertime;
import sportstats.service.season.holders.SummaryWithTies;

/**
 *
 * @author alexf
 */
@Service
public class SeasonSummaryService {

    private SeasonRepository seasonR;
    private TeamRepository teamR;
    private GameRepository gameR;
    private ResultRepository resultR;

    private String hocckey = "hockey";
    private String bandy = "bandy";
    private String floorball = "floorball";
    private String fotball = "fotball";
    private String basket = "basket";
    private String handboll = "handboll";
    private String volleyball = "volleyball";

    @Autowired
    public SeasonSummaryService(SeasonRepository season, TeamRepository team,
            GameRepository game, ResultRepository result) {
        this.seasonR = season;
        this.teamR = team;
        this.gameR = game;
        this.resultR = result;
    }

    public List<SeasonSumType> getSeasonSummary(Long seasonId) {
        List<Team> teamList = getAllTeamsInSeason(seasonId);
        List<SeasonSumType> summaryHolder = new ArrayList<>();
        for (Team team : teamList) {
            Long teamId = team.getId();
            String teamName = team.getName();
            String sportName = team.getSport().getName();

            List<Game> gameList = getAllGamesForTeam(teamId);

            summaryHolder.add(calculateTeamGames(gameList, teamId, teamName, sportName));

        }
        return summaryHolder;
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
    private SeasonSumType calculateTeamGames(List<Game> gameList,
            Long teamID, String teamName, String sportName) {

        var listOfGame = gameList;
        int numberOfGamesm = listOfGame.size();
        String sportN = sportName;

        String teamN = teamName;
        int gamesWon = 0;
        int gamesLost = 0;
        int scoredGoals = 0;
        int concededGoals = 0;
        int goalDiff = 0;
        
        //Beroende på sport
        int winsOverTime = 0;
        int losesOverTime = 0;
        int gamesTied = 0;

        for (Game game : listOfGame) {
            Long gameId = game.getId();
            Result tempResult = game.getResult();
            Long teamScore = null;
            Long otherTeamScore = null;

            if (game.getHomeTeam().getId() == teamID) {
                teamScore = tempResult.getHomeTeamScore();
                otherTeamScore = tempResult.getAwayTeamScore();
                scoredGoals += teamScore;
                concededGoals += otherTeamScore;
            } else {
                teamScore = tempResult.getAwayTeamScore();
                otherTeamScore = tempResult.getHomeTeamScore();
                scoredGoals += teamScore;
                concededGoals += otherTeamScore;
            }

            if (teamScore > otherTeamScore) {
                gamesWon++;
                if (tempResult.getOvertime()||tempResult.getPenalty()) {
                    winsOverTime++;
                }

            } else if (teamScore == otherTeamScore) {
                gamesTied++;

            } else {
                gamesLost++;
                if (tempResult.getOvertime()||tempResult.getPenalty()) {
                    losesOverTime++;
                }
                
            }

        }
        goalDiff = scoredGoals - concededGoals;

        if (sportN.equalsIgnoreCase(fotball)) {
            SummaryWithTies tempHolder = new SummaryWithTies(teamName,
                    gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, 0);
            tempHolder.setGamesTied(gamesTied);
            return tempHolder;

        } else if (sportN.equalsIgnoreCase(hocckey)) {
            SummaryWithOvertime tempHolder = new SummaryWithOvertime(teamName, 
                    gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, 0);
            tempHolder.setLosesOverTimeOrPenalites(losesOverTime);
            tempHolder.setWinsOverTimeOrPenalties(winsOverTime);
            return tempHolder;

        } else if (sportN.equalsIgnoreCase(bandy)) {
            SummaryWithTies tempHolder = new SummaryWithTies(teamName, 
                    gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, 0);
            tempHolder.setGamesTied(gamesTied);
            return tempHolder;

        } else if (sportN.equalsIgnoreCase(floorball)) {
            SummaryWithOvertime tempHolder = new SummaryWithOvertime(teamName, 
                    gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, 0);
            tempHolder.setLosesOverTimeOrPenalites(losesOverTime);
            tempHolder.setWinsOverTimeOrPenalties(winsOverTime);
            return tempHolder;

        } else if (sportN.equalsIgnoreCase(basket)) {
            Summary tempHolder = new Summary(teamName, gamesWon, gamesLost, 
                    scoredGoals, concededGoals, goalDiff, 0);
            return tempHolder;
            
        } else if (sportN.equalsIgnoreCase(handboll)) {
            SummaryWithTies tempHolder = new SummaryWithTies(teamName, gamesWon,
                    gamesLost, scoredGoals, concededGoals, goalDiff, 0);
            tempHolder.setGamesTied(gamesTied);
            return tempHolder;

        } else if (sportN.equalsIgnoreCase(volleyball)) {
            Summary tempholder = new Summary(teamName, gamesWon, gamesLost,
                    scoredGoals, concededGoals, goalDiff, 0);
            return tempholder;
        }

        return null;
    }

}
