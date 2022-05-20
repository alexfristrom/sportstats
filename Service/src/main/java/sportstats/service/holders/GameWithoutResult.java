/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

import java.time.LocalDate;
import java.time.LocalTime;
import sportstats.domain.Game;

/**
 *
 * @author David Sjöblom
 */
public class GameWithoutResult {

    private final Game delegate;

    public GameWithoutResult(Game delegate) {
        this.delegate = delegate;
    }

    public Long getId() {
        return delegate.getId();
    }

    public LocalDate getDate() {
        return delegate.getDate();
    }

    public byte getRound() {
        return delegate.getRound();
    }

    public int getSpectators() {
        return delegate.getSpectators();
    }

    public String getHomeTeam() {
        return delegate.getHomeTeam().getName();
    }

    public String getAwayTeam() {
        return delegate.getAwayTeam().getName();
    }

    public Long getSeasonId() {
        return delegate.getSeason().getId();
    }
    
    public LocalTime getTime(){
        return delegate.getStartTime();
    }
}
