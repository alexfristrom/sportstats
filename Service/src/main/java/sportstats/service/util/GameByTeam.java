/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import sportstats.domain.Game;
import sportstats.domain.Team;

/**
 *
 * @author annjohansson
 */
public class GameByTeam {
    
    private Game delegate;
    
    public GameByTeam(Game delegate){
        this.delegate = delegate;
    }
    
    public Long getId() {
        return delegate.getId();
    }
    
// public String getTeamName(){
//        Team newTeam = delegate.getHomeTeam();
//        Team newTeam2 = delegate.getAwayTeam();
//        return newTeam.getName();
//    }
}
