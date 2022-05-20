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

    public SeasonSumType getPointsByRules(String teamName, int gamesWon, int gamesLost,
            int scoredGoals, int concededGoals, int goalDiff, int winsOvertimeOrPenalties,
            int losesOvertimeOrPenalites, int gamesTied, int wins3to0, int wins3to1,
            int wins3to2, int lose2to3, int lose1to3, int lose0to3) {

        switch (sport) {
            case "hockey":
                int tempGamesWon = gamesWon - winsOvertimeOrPenalties;
                points = (tempGamesWon * Integer.parseInt(prop.getProperty("hockey.win.normal.points")));
                int tempGamesLost = gamesLost - losesOvertimeOrPenalites;
                points += (tempGamesLost * Integer.parseInt(prop.getProperty("hockey.lose.normal.points")));

                points += (winsOvertimeOrPenalties * Integer.parseInt(prop.getProperty("hockey.win.overtime.points")));
                points += (losesOvertimeOrPenalites * Integer.parseInt(prop.getProperty("hockey.lose.overtime.points")));

                SummaryWithOvertime hockeyHolder = new SummaryWithOvertime(
                        teamName, gamesWon, gamesLost, scoredGoals,
                        concededGoals, goalDiff, points);
                hockeyHolder.setLosesOverTimeOrPenalites(losesOvertimeOrPenalites);
                hockeyHolder.setWinsOverTimeOrPenalties(winsOvertimeOrPenalties);

                return hockeyHolder;
            case "bandy":
                points += (gamesWon * Integer.parseInt(prop.getProperty("bandy.win.normal.points")));
                points += (gamesLost * Integer.parseInt(prop.getProperty("bandy.lose.normal.points")));
                points += (gamesTied * Integer.parseInt(prop.getProperty("bandy.tied.points")));

                SummaryWithTies bandyHolder = new SummaryWithTies(teamName,
                        gamesWon, gamesLost, scoredGoals, concededGoals,
                        goalDiff, points);
                bandyHolder.setGamesTied(gamesTied);

                return bandyHolder;
            case "floorball":
                int winsNoOverTime = gamesWon - winsOvertimeOrPenalties;
                points += (winsNoOverTime * Integer.parseInt(prop.getProperty("floorball.win.normal.points=3")));
                int loseNoOverTime = gamesLost - losesOvertimeOrPenalites;
                points += (loseNoOverTime * Integer.parseInt(prop.getProperty("floorball.lose.normal.points=0")));

                points += (winsOvertimeOrPenalties * Integer.parseInt(prop.getProperty("floorball.win.overtime.points=2")));
                points += (losesOvertimeOrPenalites * Integer.parseInt(prop.getProperty("floorball.lose.overtime.points=1")));

                SummaryWithOvertime floorballHolder = new SummaryWithOvertime(
                        teamName, gamesWon, gamesLost, scoredGoals,
                        concededGoals, goalDiff, points);
                floorballHolder.setWinsOverTimeOrPenalties(winsOvertimeOrPenalties);
                floorballHolder.setLosesOverTimeOrPenalites(losesOvertimeOrPenalites);

                return floorballHolder;
            case "fotball":
                points += (gamesWon * Integer.parseInt(prop.getProperty("fotball.win.points")));
                points += (gamesTied * Integer.parseInt(prop.getProperty("fotball.tied.points")));
                points += (gamesLost * Integer.parseInt(prop.getProperty("fotball.lose.points")));

                SummaryWithTies fotballHolder = new SummaryWithTies(teamName,
                        gamesWon, gamesLost, scoredGoals, concededGoals,
                        goalDiff, points);
                fotballHolder.setGamesTied(gamesTied);

                return fotballHolder;
            case "basket":
                points += (gamesWon * Integer.parseInt(prop.getProperty("basket.win.normal.points")));
                points += (gamesLost * Integer.parseInt(prop.getProperty("basket.lose.normal.points")));
                Summary basketHolder = new Summary(teamName, gamesWon, gamesLost,
                        scoredGoals, concededGoals, goalDiff, points);

                return basketHolder;
            case "handball":
                points += (gamesWon * Integer.parseInt(prop.getProperty("handball.win.normal.points")));
                points += (gamesLost * Integer.parseInt(prop.getProperty("handball.lose.normal.points")));
                points += (gamesTied * Integer.parseInt(prop.getProperty("handball.tied.points")));
                SummaryWithTies handballHolder = new SummaryWithTies(teamName,
                        gamesWon, gamesLost, scoredGoals, concededGoals,
                        goalDiff, points);

                return handballHolder;
            case "volleyball":
                points += (wins3to0 * Integer.parseInt(prop.getProperty("volleyball.win.threetozero.points")));
                points += (wins3to1 * Integer.parseInt(prop.getProperty("volleyball.win.threetoone.points")));
                points += (wins3to2 * Integer.parseInt(prop.getProperty("volleyball.win.threetotwo.points")));
                points += (lose2to3 * Integer.parseInt(prop.getProperty("volleyball.lose.twotothree.points")));
                points += (lose1to3 * Integer.parseInt(prop.getProperty("volleyball.lose.onetothree.points")));
                points += (lose0to3 * Integer.parseInt(prop.getProperty("volleyball.lose.zerotothree.points")));
                Summary volleyballHolder = new Summary(teamName, gamesWon,
                        gamesLost, scoredGoals, concededGoals, goalDiff, points);
                
                return volleyballHolder;
            default:
                throw new AssertionError();
        }

    }

}
