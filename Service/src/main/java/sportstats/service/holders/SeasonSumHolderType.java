/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.service.holders;

/**
 *
 * @author alexf
 */
public interface SeasonSumHolderType {

    void setTeamname(String teamName);

    void setGamesWon(int gamesWon);

    void setGamesLost(int gamesLost);

    void setScoredGoals(int scoredGoals);

    void setConcededGoals(int concededGoals);

    void setGoalDiff(int goalDiff);

    String getTeamName();

    int getGamesWon();

    int getGamesLost();

    int getScoredGoals();

    int getConcededGoals();

    int getGoalDiff();

}
