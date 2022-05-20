package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.*;

/**
 * hometeam_id, awayteam_id, season_id, result_id, round, date_Match, spectators
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

    @OneToOne
    @JoinColumn(name = "result_id")
    private Result result;

    private Byte round;

    private LocalDate dateMatch;
    
    private LocalTime startTime;

    private int spectators;

    public Game() {
        this.setSpectators(0);
    }

    public Game(Byte round) {
        this.round = round;
        this.setSpectators(0);
    }

    //Needed for the TeamGamWrapper +  saveAllGames() in resources to work / D.S.
    public Game(int round) {
        this.setSpectators(0);
        if (round <= 127 && round > 0) {
            this.round = Integer.valueOf(round).byteValue();
        } else {
            throw new IllegalArgumentException("Round is out of bounds, should be between 0 - 127.");
        }
    }

    //Needed for the TeamGamWrapper +  saveAllGames() in resources to work / D.S
    public Game(int round, LocalDate dateMatch) {
        this.setSpectators(0);
        if (round <= 127 && round > 0) {
            this.round = Integer.valueOf(round).byteValue();
        } else {
            throw new IllegalArgumentException("Round is out of bounds, should be between 0 - 127.");
        }
        this.dateMatch = dateMatch;
    }

    public Game(Byte round, LocalDate dateMatch) {
        this.setSpectators(0);
        this.round = round;
        this.dateMatch = dateMatch;
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

    public LocalDate getDate() {
        return dateMatch;
    }

    public void setDate(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public int getSpectators() {
        return spectators;
    }

    public void setSpectators(int spectators) {
        this.spectators = spectators;
    }
    
    public void setTime(LocalTime startTime){
        this.startTime = startTime;
    }
    
    public LocalTime getTime(){
        return startTime;
    }

}
