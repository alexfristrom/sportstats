/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import sportstats.domain.League;
import sportstats.domain.Sport;

/**
 *
 * @author alexf
 */
public class LeagueBySport {
    
    private League delegate;
    
    public LeagueBySport(League delegate){
        this.delegate = delegate;
    }
    
    public Long getId() {
        return delegate.getId();
    }
    
    public String getSportName(){
        Sport newSport = delegate.getSport();
        return newSport.getName();
    }
    
    

    
}
