/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Domain object for table Season.
 * Includes getters and setters for variables for the specified table
 * 
 * @author alexf
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Season implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "span_id")
    private Span span;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    private int round_tot;
    
    public Season(){
        
    }

    public Season(int round_tot, League league, Span span) {
        this.round_tot = round_tot;
        this.league = league;
        this.span = span;
    }
    
    
    public Long getId() {
        return id;
    }
    
    public Span getSpan() {
        return this.span;
    }
    public void setSpan(Span span) {
        this.span = span;
    }
    
    public League getLeague() {
        return this.league;
    }
    public void setLeague(League league) {
        this.league = league;
    }

    public int getRoundTot() {
        return round_tot;
    }
    public void setRoundTot(int round_tot) {
        this.round_tot = round_tot;
    }

}
