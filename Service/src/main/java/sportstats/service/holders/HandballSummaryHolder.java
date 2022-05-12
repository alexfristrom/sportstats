/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public class HandballSummaryHolder extends AbstractSeasonSumHolder{

    //Ska fixas för individuella sporter
    private int gamesTied;
    
    //Baserat på poängsystem för spcifika sporter
    private int points;
    
    public HandballSummaryHolder(String teamName, int gamesWon, int gamesLost, 
            int scoredGoals, int concededGoals, int goalDiff) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff);
    }

    public HandballSummaryHolder() {
        
    }
    
    public void setGamesTied(int gamesTied){
        this.gamesTied = gamesTied;
    }
    
    public int getGamesTied(){
        return this.gamesTied;
    }  
    
    
}
