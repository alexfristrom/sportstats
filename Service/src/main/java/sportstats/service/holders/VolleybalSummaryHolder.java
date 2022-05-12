/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public class VolleybalSummaryHolder extends AbstractSeasonSumHolder implements SeasonSumHolderType{

    //Baserat på poängsystem för spcifika sporter
    private int points;
    
    public VolleybalSummaryHolder(String teamName, int gamesWon, int gamesLost, 
            int scoredGoals, int concededGoals, int goalDiff) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff);
    }

    public VolleybalSummaryHolder() {
        
    }
    
    
    
}
