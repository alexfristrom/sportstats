/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public class HockeySummaryHolder extends AbstractSeasonSumHolder implements SeasonSumHolderType{

    //Ska fixas för individuella sporter
    private int winsOverTimeOrPenalties;
    private int losesOverTimeOrPenalites;
    
    //Baserat på poängsystem för spcifika sporter
    private int points;
    
    public HockeySummaryHolder(String teamName, int gamesWon, int gamesLost, int scoredGoals, int concededGoals, int goalDiff) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff);
    }

    public HockeySummaryHolder() {
    }

    public int getWinsOverTimeOrPenalties() {
        return winsOverTimeOrPenalties;
    }

    public int getLosesOverTimeOrPenalites() {
        return losesOverTimeOrPenalites;
    }

    public void setWinsOverTimeOrPenalties(int winsOverTimeOrPenalties) {
        this.winsOverTimeOrPenalties = winsOverTimeOrPenalties;
    }

    public void setLosesOverTimeOrPenalites(int losesOverTimeOrPenalites) {
        this.losesOverTimeOrPenalites = losesOverTimeOrPenalites;
    }
    
    
    
}
