/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.util.List;
import sportstats.domain.Game;

/**
 *
 * @author David Sjöblom
 */
public class TeamGameWrapper {

    private List<Game> game;
    private List<Long> homeTeam;
    private List<Long> awayTeam;
    private Long seasonId;

    public TeamGameWrapper() {

    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setHomeTeam(List<Long> team) {
        this.homeTeam = team;
    }

    public void setAwayTeam(List<Long> team) {
        this.awayTeam = team;
    }

    public List<Long> getHomeTeam() {
        return homeTeam;
    }

    public List<Long> getAwayTeam() {
        return awayTeam;
    }
    
    public void setSeasonId(Long seasonId){
        this.seasonId = seasonId;
    }
    public Long getSeasonId(){
        return seasonId;
    }
}
