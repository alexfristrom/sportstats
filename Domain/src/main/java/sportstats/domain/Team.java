/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author David Sjöblom
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Team implements Listable {

    public Team() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToOne
    @JoinColumn(name = "arena_id")
    private Arena arena;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }
    
    public Sport getSport() {
        return sport;
    }

    public Season getSeason() {
        return season;
    }

    public Arena getArena() {
        return arena;
    }
}
