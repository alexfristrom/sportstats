/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import sportstats.service.season.holders.SeasonSumType;
import sportstats.service.season.holders.Summary;
import sportstats.service.season.holders.SummaryStats;
import sportstats.service.season.holders.SummaryWithOvertime;
import sportstats.service.season.holders.SummaryWithTies;

/**
 * A rule class that reads rules from a proprties file given the sport and then
 * caclulates the points for the team
 *
 * @author alexf
 */
public class SportRuleHandler {

    private Properties prop = new Properties();
    private String sport;
    private int points;

    //Kan implemeteras för använding av regler för spcecifika leauges
    //private String league;
    public SportRuleHandler(String sportName) {
        this.sport = sportName;
        sport = sport.toLowerCase();
        sport = sport.trim();

        try (InputStream input = SportRuleHandler.class.getClassLoader()
                .getResourceAsStream("rules.properties")) {

            if (input == null) {
                System.out.println("Unable to find rules.properties");
            }

            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SeasonSumType getPointsByRules(SummaryStats stats) {

        switch (sport) {
            case "hockey":
                int tempGamesWon = stats.getGamesWon() - stats.getWinsOverTime();
                points = (tempGamesWon * Integer.parseInt(prop.getProperty("hockey.win.normal.points")));
                int tempGamesLost = stats.getGamesLost() - stats.getLosesOverTime();
                points += (tempGamesLost * Integer.parseInt(prop.getProperty("hockey.lose.normal.points")));

                points += (stats.getWinsOverTime() * Integer.parseInt(prop.getProperty("hockey.win.overtime.points")));
                points += (stats.getLosesOverTime() * Integer.parseInt(prop.getProperty("hockey.lose.overtime.points")));

                SummaryWithOvertime hockeyHolder = new SummaryWithOvertime(
                        stats.getTeamN(), stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);
                hockeyHolder.setLosesOverTimeOrPenalites(stats.getLosesOverTime());
                hockeyHolder.setWinsOverTimeOrPenalties(stats.getWinsOverTime());

                return hockeyHolder;
            case "bandy":
                points += (stats.getGamesWon() * Integer.parseInt(prop.getProperty("bandy.win.normal.points")));
                points += (stats.getGamesLost() * Integer.parseInt(prop.getProperty("bandy.lose.normal.points")));
                points += (stats.getGamesTied() * Integer.parseInt(prop.getProperty("bandy.tied.points")));

                SummaryWithTies bandyHolder = new SummaryWithTies(stats.getTeamN(), 
                        stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);
                bandyHolder.setGamesTied(stats.getGamesTied());

                return bandyHolder;
            case "floorball":
                int winsNoOverTime = stats.getGamesWon() - stats.getWinsOverTime();
                points += (winsNoOverTime * Integer.parseInt(prop.getProperty("floorball.win.normal.points=3")));
                int loseNoOverTime = stats.getGamesLost() - stats.getLosesOverTime();
                points += (loseNoOverTime * Integer.parseInt(prop.getProperty("floorball.lose.normal.points=0")));

                points += (stats.getWinsOverTime() * Integer.parseInt(prop.getProperty("floorball.win.overtime.points=2")));
                points += (stats.getLosesOverTime() * Integer.parseInt(prop.getProperty("floorball.lose.overtime.points=1")));

                SummaryWithOvertime floorballHolder = new SummaryWithOvertime(
                        stats.getTeamN(), stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);
                floorballHolder.setWinsOverTimeOrPenalties(stats.getWinsOverTime());
                floorballHolder.setLosesOverTimeOrPenalites(stats.getLosesOverTime());

                return floorballHolder;
            case "fotball":
                points += (stats.getGamesWon() * Integer.parseInt(prop.getProperty("fotball.win.points")));
                points += (stats.getGamesTied() * Integer.parseInt(prop.getProperty("fotball.tied.points")));
                points += (stats.getGamesLost()* Integer.parseInt(prop.getProperty("fotball.lose.points")));

                SummaryWithTies fotballHolder = new SummaryWithTies(
                        stats.getTeamN(), stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);
                fotballHolder.setGamesTied(stats.getGamesTied());

                return fotballHolder;
            case "basket":
                points += (stats.getGamesWon() * Integer.parseInt(prop.getProperty("basket.win.normal.points")));
                points += (stats.getGamesLost() * Integer.parseInt(prop.getProperty("basket.lose.normal.points")));
                Summary basketHolder = new Summary(stats.getTeamN(), 
                        stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);

                return basketHolder;
            case "handball":
                points += (stats.getGamesWon() * Integer.parseInt(prop.getProperty("handball.win.normal.points")));
                points += (stats.getGamesLost() * Integer.parseInt(prop.getProperty("handball.lose.normal.points")));
                points += (stats.getGamesTied() * Integer.parseInt(prop.getProperty("handball.tied.points")));
                SummaryWithTies handballHolder = new SummaryWithTies(stats.getTeamN(), 
                        stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);

                return handballHolder;
            case "volleyball":
                points += (stats.getWins3to0() * Integer.parseInt(prop.getProperty("volleyball.win.threetozero.points")));
                points += (stats.getWins3to1() * Integer.parseInt(prop.getProperty("volleyball.win.threetoone.points")));
                points += (stats.getWins3to2() * Integer.parseInt(prop.getProperty("volleyball.win.threetotwo.points")));
                points += (stats.getLose2to3() * Integer.parseInt(prop.getProperty("volleyball.lose.twotothree.points")));
                points += (stats.getLose1to3() * Integer.parseInt(prop.getProperty("volleyball.lose.onetothree.points")));
                points += (stats.getLose0to3() * Integer.parseInt(prop.getProperty("volleyball.lose.zerotothree.points")));
                Summary volleyballHolder = new Summary(stats.getTeamN(), 
                        stats.getGamesWon(), stats.getGamesLost(), stats.getScoredGoals(),
                        stats.getConcededGoals(), stats.getGoalDiff(), points);
                
                return volleyballHolder;
            default:
                throw new AssertionError();
        }

    }

}
