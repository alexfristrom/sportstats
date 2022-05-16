/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.service.season.holders;

/**
 *
 * @author alexf
 */
public interface SeasonSumType {

    void setTeamname(String teamName);

    void setGamesWon(int gamesWon);

    void setGamesLost(int gamesLost);

    void setScoredGoals(int scoredGoals);

    void setConcededGoals(int concededGoals);

    void setGoalDiff(int goalDiff);
    
    void setPoints(int points);
    
    void setRank(int rank);
    
    int getRank();

    String getTeamName();
    
    int getPoints();

    int getGamesWon();

    int getGamesLost();

    int getScoredGoals();

    int getConcededGoals();

    int getGoalDiff();
    
}
