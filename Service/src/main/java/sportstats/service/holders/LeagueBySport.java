/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

import sportstats.domain.League;

/**
 * Ties Sport and league to a class so it can be used to show information
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
    
    public String getLeagueName(){
        return delegate.getName();
    }
    
//Kan användas för att visa sportnament också
//    public String getSportName(){
//        Sport newSport = delegate.getSport();
//        return newSport.getName();
//    }
//    
    

    
}
