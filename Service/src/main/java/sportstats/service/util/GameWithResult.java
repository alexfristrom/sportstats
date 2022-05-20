/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import sportstats.domain.Game;
import sportstats.domain.Result;

/**
 *
 * @author David Sjöblom
 */
public class GameWithResult {
    private final Game delegate;
    
    public GameWithResult(Game delegate){
        this.delegate = delegate;
    }
    
    public Long getId(){
        return delegate.getId();
    }
    
    public LocalDate getDate(){
        return delegate.getDate();
    }
    
    public byte getRound(){
        return delegate.getRound();
    }
    
    public int getSpectators(){
        return delegate.getSpectators();
    }
    
    public String getHomeTeam(){
        return delegate.getHomeTeam().getName();
    }
    
    public String getAwayTeam(){
        return delegate.getAwayTeam().getName();
    }
    
    public Result getResult(){
        return delegate.getResult();
    }
    
    public Long getSeasonId(){
        return delegate.getSeason().getId();
    }
}
