/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.season.holders;

/**
 *
 * @author alexf
 */
public class Summary extends AbstractSeasonSum{

    public Summary(String teamName, int gamesWon, int gamesLost,
            int scoredGoals, int concededGoals, int goalDiff, int points) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff, points);
    }

    public Summary() {
        
    }
    
}
