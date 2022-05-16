/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.time.LocalDateTime;
import sportstats.domain.Game;
import sportstats.domain.Result;
import sportstats.domain.Season;
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
    
    public Team getHomeTeam() {
        return delegate.getHomeTeam();
    }
    
    public Team getAwayTeam() {
        return delegate.getAwayTeam();
    }
    
    public Season getSeason() {
        return delegate.getSeason();
    }
    
    public Result getResult() {
        return delegate.getResult();
    }
    
    public Byte getRound() {
        return delegate.getRound();
    }
     
    public LocalDateTime getDate() {
        return delegate.getDate();
    }
      
    public int getSpectators() {
        return delegate.getSpectators();
    }
    
// public String getTeamName(){
//        Team newTeam = delegate.getHomeTeam();
//        Team newTeam2 = delegate.getAwayTeam();
//        return newTeam.getName();
//    }
}
