/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.util.List;
import sportstats.domain.Game;

/**
 * A help class that only calculates the biggest goal difference
 * and returns the game with the biggest goal difference.
 * @author annjohansson
 */
public class CalcBiggestGoalDiffBetweenGames {
    
    public CalcBiggestGoalDiffBetweenGames(){
        
    }
    
    public Game findBiggestGoalDiff(List<Game> list){
        Game game = null;
        Game current;
        int diff = 0;
        int biggestDiff = 0;
        
        for(int i = 0; i < list.size(); i++){
        current = list.get(i);
        int home = current.getResult().getHomeTeamScore();
        int away = current.getResult().getAwayTeamScore();
        diff = Math.abs(home-away);
            if(biggestDiff < diff){
            biggestDiff = diff;
            game = current;
            }
        }
       return game;
    }
   
            
    
}
