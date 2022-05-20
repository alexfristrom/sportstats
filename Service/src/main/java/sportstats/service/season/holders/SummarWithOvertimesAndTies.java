/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.season.holders;

import sportstats.service.season.holders.AbstractSeasonSum;

/**
 *
 * @author alexf
 */
public class SummarWithOvertimesAndTies extends AbstractSeasonSum {

    private int gamesTied;
    private int winsOverTimeOrPenalties;
    private int losesOverTimeOrPenalites;

    public SummarWithOvertimesAndTies(String teamName, int gamesWon, int gamesLost, int scoredGoals, int concededGoals, int goalDiff, int points) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, points);
    }

    public SummarWithOvertimesAndTies() {

    }

    //Getters
    public int getGamesTied() {
        return this.gamesTied;
    }

    public int getWinsOverTimeOrPenalties() {
        return winsOverTimeOrPenalties;
    }

    public int getLosesOverTimeOrPenalites() {
        return losesOverTimeOrPenalites;
    }

    //Setters
    public void setGamesTied(int gamesTied) {
        this.gamesTied = gamesTied;
    }

    public void setWinsOverTimeOrPenalties(int winsOverTimeOrPenalties) {
        this.winsOverTimeOrPenalties = winsOverTimeOrPenalties;
    }

    public void setLosesOverTimeOrPenalites(int losesOverTimeOrPenalites) {
        this.losesOverTimeOrPenalites = losesOverTimeOrPenalites;
    }
    
   

}
