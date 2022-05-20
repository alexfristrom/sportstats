/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.ArrayList;
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
import sportstats.service.season.holders.SummaryStats;
import sportstats.service.util.SportRuleHandler;

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
        Collections.sort(summaryHolder, new SortByPoints());
        for (int i = 0; i < summaryHolder.size(); i++) {
            summaryHolder.get(i).setRank(i + 1);
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

    private SeasonSumType calculateTeamGames(List<Game> gameList,
            Long teamID, String teamName, String sportName) {

        var listOfGame = gameList;
        String sportN = sportName;

        SummaryStats stats = new SummaryStats(teamName);
      
        for (Game game : listOfGame) {
            Long gameId = game.getId();
            Result tempResult = game.getResult();
            int teamScore = 0;
            int otherTeamScore = 0;

            if (game.getHomeTeam().getId().equals(teamID)) {
                teamScore = tempResult.getHomeTeamScore();
                otherTeamScore = tempResult.getAwayTeamScore();
                stats.setScoredGoals(teamScore);
                stats.setConcededGoals(otherTeamScore);
            } else {
                teamScore = tempResult.getAwayTeamScore();
                otherTeamScore = tempResult.getHomeTeamScore();
                stats.setScoredGoals(teamScore);
                stats.setConcededGoals(otherTeamScore);
            }

            if (teamScore > otherTeamScore) {
                stats.incGamesWon();
                if (tempResult.getOvertime() || tempResult.getPenalty()) {
                    stats.incWinsOverTime();
                }

                //Bara för volleyball. kankse kan implemnteras på ett annats sätt
                if (sportN.equalsIgnoreCase("volleball")) {
                    if ((teamScore == 3) && (otherTeamScore == 0)) {
                        stats.incWins3to0();
                    } else if ((teamScore == 3) && (otherTeamScore == 1)) {
                        stats.incsWins3to1();
                    } else {
                        stats.incWins3to2();
                    }
                }

            } else if (teamScore == otherTeamScore) {
                stats.incGamesTied();

            } else {
                stats.incGamesLost();
                if (tempResult.getOvertime() || tempResult.getPenalty()) {
                    stats.incLosesOverTime();
                }

                //Bara för volleyball
                if (sportN.equalsIgnoreCase("volleball")) {
                    if ((teamScore == 2) && (otherTeamScore == 3)) {
                        stats.incLose2to3();
                    } else if ((teamScore == 1) && (otherTeamScore == 3)) {
                        stats.incLose1to3();
                    } else {
                        stats.incLose0to3();
                    }
                }
            }
        }
        stats.calcGoalDiff();

        SportRuleHandler ruleHandler = new SportRuleHandler(sportN);
        return ruleHandler.getPointsByRules(stats);

    }

    private class SortByPoints implements Comparator<SeasonSumType> {

        @Override
        public int compare(SeasonSumType type1, SeasonSumType type2) {
            if (type1.getPoints() < type2.getPoints()) {
                return 1;

            } else if (type1.getPoints() > type2.getPoints()) {
                return -1;

            } else {

                if (type1.getGoalDiff() > type2.getGoalDiff()) {
                    return -1;

                } else {
                    return 1;
                }

            }

        }

    }

    public List<SeasonSumType> getSeasonsSummary(String seasonIds) {
        String firstLong = "";
        String secondLong = "";
        boolean secondNumber = false;
        List<SeasonSumType> summaryHolder = new ArrayList();
        
        //Collects start/end interval, expected input as string: long - character - long
        for (char a : seasonIds.toCharArray()) {
            if (Character.isDigit(a) && !secondNumber) {
                firstLong = firstLong + a;
            } else if (!secondNumber) {
                secondNumber = true;
            }
            if (secondNumber && Character.isDigit(a)) {
                secondLong = secondLong + a;
            }
        }

        Long startInterval = Long.parseLong(firstLong);
        Long endInterval = Long.parseLong(secondLong);
        for (long i = startInterval; i <= endInterval; i++) {
            summaryHolder.addAll(getSeasonSummary(i));
        }
        
        return summaryHolder;
    }
}
