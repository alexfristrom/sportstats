/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.holders;

import sportstats.domain.Game;
import sportstats.domain.Span;

/**
 *
 * @author David Sjöblom
 */
public class Matchups {

    private final Game game;

    public Matchups(Game delegate) {
        this.game = delegate;
    }

    public String getHomeTeamName() {
        return game.getHomeTeam().getName();
    }

    public String getAwayTeamName() {
        return game.getAwayTeam().getName();
    }

    public int getRoundTot() {
        return game.getSeason().getRoundTot();
    }

    public Span getSpan() {
        return game.getSeason().getSpan();
    }

    public String getLeague() {
        return game.getSeason().getLeague().getName();
    }

    public byte getRound() {
        return game.getRound();
    }
}
