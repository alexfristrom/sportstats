/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public class BandySummaryHolder extends AbstractSeasonSumHolder implements SeasonSumHolderType {

    //Ska fixas för individuella sporter
    private int gamesTied;

    //Baserat på poängsystem för spcifika sporter
    private int points;

    public BandySummaryHolder(String teamName, int gamesWon, int gamesLost, int scoredGoals, int concededGoals, int goalDiff) {
        super(teamName, gamesWon, gamesLost, scoredGoals, concededGoals, goalDiff);
    }

    public BandySummaryHolder() {
    }

    public void setGamesTied(int gamesTied) {
        this.gamesTied = gamesTied;
    }

    public int getGamesTied() {
        return gamesTied;
    }

}
