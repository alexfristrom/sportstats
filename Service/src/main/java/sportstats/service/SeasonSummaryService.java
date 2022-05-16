/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import sportstats.service.season.holders.SportRuleHandler;

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

        //Sorting and points
        summaryHolder = sort(summaryHolder);

        return summaryHolder;
    }

    private List<Team> getAllTeamsInSeason(Long seasonId) {
        List<Team> listOfTeams = teamR.listBySeason(seasonId);
        return listOfTeams;
    }

    private List<Game> getAllGamesForTeam(Long teamId) {
        return gameR.listAllByTeam(teamId);
    }

    private List<SeasonSumType> sort(List<SeasonSumType> listOfHolders) {
        List<SeasonSumType> newListOfHolders = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < listOfHolders.size(); i++) {
            intList.add(listOfHolders.get(i).getPoints());
        }

        Collections.sort(intList);

        for (int i = 0; i < listOfHolders.size(); i++) {

            for (int j = 0; j < listOfHolders.size(); j++) {
                if (intList.get(i) == listOfHolders.get(j).getPoints()) {
                    newListOfHolders.add(listOfHolders.get(j));
                    newListOfHolders.get(i).setRank(listOfHolders.size() - j);
                }
            }

        }

        return newListOfHolders;
    }

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

        //Används vid sortering
        int goalDiff = 0;

        //Beroende på sport
        int winsOverTime = 0;
        int losesOverTime = 0;
        int gamesTied = 0;

        // Enbart för volleyball
        int wins3to0 = 0;
        int wins3to1 = 0;
        int wins3to2 = 0;
        int lose2to3 = 0;
        int lose1to3 = 0;
        int lose0to3 = 0;

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
                if (tempResult.getOvertime() || tempResult.getPenalty()) {
                    winsOverTime++;
                }

                //Bara för volleyball. kankse kan implemnteras på ett annats sätt
                if (sportN.equalsIgnoreCase("volleball")) {
                    if ((teamScore == 3) && (otherTeamScore == 0)) {
                        wins3to0++;
                    } else if ((teamScore == 3) && (otherTeamScore == 1)) {
                        wins3to1++;
                    } else {
                        wins3to2++;
                    }
                }

            } else if (teamScore == otherTeamScore) {
                gamesTied++;

            } else {
                gamesLost++;
                if (tempResult.getOvertime() || tempResult.getPenalty()) {
                    losesOverTime++;
                }

                //Bara för volleyball
                if (sportN.equalsIgnoreCase("volleball")) {
                    if ((teamScore == 2) && (otherTeamScore == 3)) {
                        lose2to3++;
                    } else if ((teamScore == 1) && (otherTeamScore == 3)) {
                        lose1to3++;
                    } else {
                        lose0to3++;
                    }
                }
            }
        }
        goalDiff = scoredGoals - concededGoals;

        SportRuleHandler ruleHandler = new SportRuleHandler(sportN);
        return ruleHandler.getPointsByRules(teamName, gamesWon, gamesLost, scoredGoals,
                concededGoals, goalDiff, winsOverTime, losesOverTime, gamesTied,
                wins3to0, wins3to1, wins3to2, lose2to3, lose1to3, lose0to3);

    }

}
