/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.util.List;
import sportstats.domain.Game;
import sportstats.domain.Result;

/**
 *
 * @author annjohansson
 */
public class GoalDiff {
    
    private List<Game> list;
    private Result result;
    
    public GoalDiff(List<Game> list){
        this.list = list;
        
    }
    
    public Game test(List<Game> list){
        Game big;
        Game curr;
        int diff;
        int bigDiff= 0;
        
        for(int i = 0; i < list.size(); i++){
        curr = list.get(i);
        int home = curr.getResult().getHomeTeamScore();
        int away = curr.getResult().getAwayTeamScore();
        diff = Math.abs((home-away)*(home-away));
            if(bigDiff < diff){
            bigDiff = diff;
            big = curr;
            }
        }
       return big; 
    }
   
            
    
}
