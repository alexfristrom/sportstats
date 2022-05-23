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

        return common(summaryHolder);
    }

    public List<SeasonSumType> getSeasonSummaryResultFilter(Long seasonId, String homeOraway) {
        List<Team> teamList = getAllTeamsInSeason(seasonId);
        List<SeasonSumType> summaryHolder = new ArrayList<>();
        for (Team team : teamList) {
            Long teamId = team.getId();
            String teamName = team.getName();
            String sportName = team.getSport().getName();
            List<Game> gameList = new ArrayList();
            if (homeOraway.equals("home")) {
                gameList = getAllGamesForHomeTeam(teamId);
            }
            if (homeOraway.equals("away")) {
                gameList = getAllGamesForAwayTeam(teamId);
            }
            summaryHolder.add(calculateTeamGames(gameList, teamId, teamName, sportName));

        }

        return common(summaryHolder);
    }

    public List<SeasonSumType> getSeasonSummaryRoundFilter(Long seasonId, String interval) {
        List<Team> teamList = getAllTeamsInSeason(seasonId);
        List<SeasonSumType> summaryHolder = new ArrayList<>();

        for (Team team : teamList) {
            Long teamId = team.getId();
            String teamName = team.getName();
            String sportName = team.getSport().getName();

            boolean secondNumber = false;
            String firstByte = "";
            String secondByte = "";

            for (char a : interval.toCharArray()) {
                if (Character.isDigit(a) && !secondNumber) {
                    firstByte = firstByte + a;
                } else if (!secondNumber) {
                    secondNumber = true;
                }
                if (secondNumber && Character.isDigit(a)) {
                    secondByte = secondByte + a;
                }
            }
            List<Game> gameList = gameR.listMatchesBySeasonIdAndRoundFilter(seasonId, Byte.parseByte(firstByte), Byte.parseByte(secondByte));
            summaryHolder.add(calculateTeamGames(gameList, teamId, teamName, sportName));

        }

        return common(summaryHolder);
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

    private List<SeasonSumType> common(List<SeasonSumType> summaryHolder) {

        //Sorting and points
        Collections.sort(summaryHolder, new SortByPoints());
        for (int i = 0; i < summaryHolder.size(); i++) {
            summaryHolder.get(i).setRank(i + 1);
        }

        return summaryHolder;
    }

    private List<Game> getAllGamesForHomeTeam(Long teamId) {
        return gameR.listHomeByTeam(teamId);
    }

    private List<Game> getAllGamesForAwayTeam(Long teamId) {
        return gameR.listAwayByTeam(teamId);
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
            int teamScore = 0;
            int otherTeamScore = 0;

            if (game.getHomeTeam().getId().equals(teamID)) {
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

}
