/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

/**
 *
 * @author alexf
 */
public class SeasonSummaryHolder {

    private String teamName;
    private int gamesWon;
    private int gamesTied;
    private int gamesLost;

    private int scoredGoals;
    private int concededGoals;
    private int goalDiff;
    
    //Ska fixas
    private int points;
    private int winsOverTimeOrPenalties;
    private int losesOverTimeOrPenalites;

    public SeasonSummaryHolder() {

    }
    
    public void setTeamname(String teamName){
        this.teamName = teamName;
    }
    
    public void setGamesWon(int gamesWon){
        this.gamesWon = gamesWon;
    }
    
    public void setGamesTied(int gamesTied){
        this.gamesTied = gamesTied;
    }
    
    public void setGamesLost(int gamesLost){
        this.gamesLost = gamesLost;
    }
    
    public void setScoredGoals(int scoredGoals){
        this.scoredGoals = scoredGoals;
    }
    
    public void setConcededGoals(int concededGoals){
        this.concededGoals = concededGoals;
    }
    
    public void setGoalDiff(int goalDiff){
        this.goalDiff = goalDiff;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesTied() {
        return gamesTied;
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
    
    
    

}
