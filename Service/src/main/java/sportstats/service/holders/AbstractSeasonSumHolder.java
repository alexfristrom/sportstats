/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public abstract class AbstractSeasonSumHolder implements SeasonSumHolderType {

    //Standard för alla sporter
    private String teamName;
    private int gamesWon;
    private int gamesLost;
    private int scoredGoals;
    private int concededGoals;
    private int goalDiff;

    public AbstractSeasonSumHolder(String teamName, int gamesWon, int gamesLost,
            int scoredGoals, int concededGoals, int goalDiff) {

        this.teamName = teamName;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.scoredGoals = scoredGoals;
        this.concededGoals = concededGoals;
        this.goalDiff = goalDiff;
    }
    
    public AbstractSeasonSumHolder(){
        
    }

    @Override
    public void setTeamname(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    @Override
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Override
    public void setConcededGoals(int concededGoals) {
        this.concededGoals = concededGoals;
    }

    @Override
    public void setGoalDiff(int goalDiff) {
        this.goalDiff = goalDiff;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int getGamesLost() {
        return gamesLost;
    }

    @Override
    public int getScoredGoals() {
        return scoredGoals;
    }

    @Override
    public int getConcededGoals() {
        return concededGoals;
    }

    @Override
    public int getGoalDiff() {
        return goalDiff;
    }

}
