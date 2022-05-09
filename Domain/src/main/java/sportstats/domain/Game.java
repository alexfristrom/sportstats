package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * hometeam_id, awayteam_id, season_id, result_id, round, date, spectators
 *
 * @author danielw
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "hometeam_id")
    private Team hometeam;
    
    @ManyToOne
    @JoinColumn(name = "awayteam_id")
    private Team awayteam;
    
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    
    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result result;

    private Byte round;

    private LocalDateTime dateMatch;

    private Long spectators;

    public Game() {
    }

    public Game(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public Team getHomeTeam() {
        return hometeam;
    }

    public void setHomeTeam(Team hometeam) {
        this.hometeam = hometeam;
    }

    public Team getAwayTeam() {
        return awayteam;
    }

    public void setAwayTeam(Team awayteam) {
        this.awayteam = awayteam;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {

        this.result = result;
    }

    public Byte getRound() {
        return round;
    }

    public void setRound(Byte round) {
        this.round = round;
    }

    public LocalDateTime getDate() {
        return dateMatch;
    }

    public void setDate(LocalDateTime dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Long getSpectators() {
        return spectators;
    }

    public void setSpectators(Long spectators) {
        this.spectators = spectators;
    }

}
