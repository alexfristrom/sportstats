/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

import sportstats.domain.Season;

/**
 * Ties Sport and league to a class so it can be used to show information
 * 
 * @author alexf
 */
public class SeasonByLeague {
    
    private Season delegate;
    
    public SeasonByLeague(Season delegate){
        this.delegate = delegate;
    }
    
    public Long getId() {
        return delegate.getId();
    }
    
    public Long getSeasonLeagueId(){
        return delegate.getLeague().getId();
    }
    
    public Long getSeasonSpanId(){
        return delegate.getSpan().getId();
    }
    
    public int getSeasonRoundTot(){
        return delegate.getRoundTot();
    }
    
    
    

    
}
