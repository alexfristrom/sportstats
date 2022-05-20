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
public class SummaryWithOvertime extends AbstractSeasonSum {

    private int winsOverTimeOrPenalties;
    private int losesOverTimeOrPenalites;

    public SummaryWithOvertime(String teamName, int gamesWon, int gamesLost, int scoredGoals, int concededGoals, int goalDiff, int points) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, points);
    }

    public SummaryWithOvertime() {

    }

    //Getters
    public int getWinsOverTimeOrPenalties() {
        return winsOverTimeOrPenalties;
    }

    public int getLosesOverTimeOrPenalites() {
        return losesOverTimeOrPenalites;
    }

    //Setters
    public void setWinsOverTimeOrPenalties(int winsOverTimeOrPenalties) {
        this.winsOverTimeOrPenalties = winsOverTimeOrPenalties;
    }

    public void setLosesOverTimeOrPenalites(int losesOverTimeOrPenalites) {
        this.losesOverTimeOrPenalites = losesOverTimeOrPenalites;
    }
    
    
    

}
