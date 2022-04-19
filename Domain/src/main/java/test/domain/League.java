/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
    public League() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(targetEntity = Sport.class)
    @JoinColumn(name = "sport_id", referencedColumnName = "id")
    private Long sport_id;
    
    @Override
    public Long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getSportId(){
        return sport_id;
    }
    
    public void setSportId(Long id){
        this.sport_id = id;
    }
    

}
