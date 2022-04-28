/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
public class League implements Listable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    
    public League() {
    }
    
    public League(Sport sport) {
        this.sport = sport;
    }
    
    @Override
    public Long getId(){
        return id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Sport getSport(){
        return this.sport;
    }
    
    public void setSport(Sport sport){
        this.sport = sport;
    }
    

}
