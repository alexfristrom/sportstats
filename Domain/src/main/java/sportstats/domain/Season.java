/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Season implements Listable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Span.class)
    @JoinColumn(name = "span_id", referencedColumnName = "id")
    private Long span_id;
    @ManyToOne(targetEntity = League.class)
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    private Long league_id;

    private int round_tot;

    public Season() {

    }

    @Override
    public Long getId() {
        return id;
    }
    
    public Long getSpanId() {
        return this.span_id;
    }
    public void setSpanId(Long span_id) {
        this.span_id = span_id;
    }
    
    public Long getLeagueId() {
        return this.league_id;
    }
    public void setLeagueId(Long league_id) {
        this.league_id = league_id;
    }

    public int getRoundTot() {
        return round_tot;
    }
    public void setRoundTot(int round_tot) {
        this.round_tot = round_tot;
    }

}
