/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.season.holders;

/**
 *
 * @author alexf
 */
public class SummaryStats {

    private String teamN;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int scoredGoals = 0;
    private int concededGoals = 0;

    //Används vid sortering
    private int goalDiff = 0;

    //Beroende på sport
    private int winsOverTime = 0;
    private int losesOverTime = 0;
    private int gamesTied = 0;

    // Enbart för volleyball
    private int wins3to0 = 0;
    private int wins3to1 = 0;
    private int wins3to2 = 0;
    private int lose2to3 = 0;
    private int lose1to3 = 0;
    private int lose0to3 = 0;
    
    public SummaryStats(String teamN){
        this.teamN = teamN;
    }

    public void setTeamN(String teamN) {
        this.teamN = teamN;
    }

    public void incGamesWon() {
        this.gamesWon++;
    }

    public void incGamesLost() {
        this.gamesLost++;
    }

    public void setScoredGoals(int teamScore) {
        this.scoredGoals += teamScore;
    }

    public void setConcededGoals(int otherTeamScore) {
        this.concededGoals += otherTeamScore;
    }

    public void calcGoalDiff() {
        this.goalDiff = this.scoredGoals - this.concededGoals;
    }

    public void incWinsOverTime() {
        this.winsOverTime++;
    }

    public void incLosesOverTime() {
        this.losesOverTime++;
    }

    public void incGamesTied() {
        this.gamesTied++;
    }

    public void incWins3to0() {
        this.wins3to0++;
    }

    public void incsWins3to1() {
        this.wins3to1++;
    }

    public void incWins3to2() {
        this.wins3to2++;
    }

    public void incLose2to3() {
        this.lose2to3++;
    }

    public void incLose1to3() {
        this.lose1to3++;
    }

    public void incLose0to3() {
        this.lose0to3++;
    }

    public String getTeamN() {
        return teamN;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public int getConcededGoals() {
        return concededGoals;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public int getWinsOverTime() {
        return winsOverTime;
    }

    public int getLosesOverTime() {
        return losesOverTime;
    }

    public int getGamesTied() {
        return gamesTied;
    }

    public int getWins3to0() {
        return wins3to0;
    }

    public int getWins3to1() {
        return wins3to1;
    }

    public int getWins3to2() {
        return wins3to2;
    }

    public int getLose2to3() {
        return lose2to3;
    }

    public int getLose1to3() {
        return lose1to3;
    }

    public int getLose0to3() {
        return lose0to3;
    }

    
    
}
