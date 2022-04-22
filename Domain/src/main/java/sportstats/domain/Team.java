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
    @Column(unique=true)
    private String name;

    @ManyToOne(targetEntity = Season.class)
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Long season_id;
    @ManyToOne(targetEntity = Arena.class)
    @JoinColumn(name = "arena_id", referencedColumnName = "id")
    private Long arena_id;

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

    public void setSeasonId(Long season_id) {
        this.season_id = season_id;
    }

    public void setArenaId(Long arena_id) {
        this.arena_id = arena_id;
    }

    public Long getSeasonId() {
        return season_id;
    }

    public Long getArenaId() {
        return arena_id;
    }
}
