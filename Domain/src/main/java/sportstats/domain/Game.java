package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import java.util.Date;
import javax.persistence.*;
/**
 * hometeam_id, awayteam_id, season_id, result_id, round, date, spectators
 *
 * @author danielw
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Game implements Listable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long hometeam_id;
    
    private Long awayteam_id;
    
    private Long season_id;
    
    private Long result_id;
    
    private Byte round;
    
    private Date dateMatch;
    
    private Long spectators;
    
    public Game() {
    }

    public Game(Long id) {
        this.id = id;
        
    }

    @Override
    public Long getId() {
        return id;
    }

    
    public Long getHomeTeamId() {
        return hometeam_id;
    }

    public void setHomeTeamId(Long hometeam_score) {
        this.hometeam_id = hometeam_score;
    }
    
    public Long getAwayTeamId() {
        return awayteam_id;
    }

    public void setAwayTeamId(Long awayteam_score) {
        this.awayteam_id = awayteam_id;
    }
    
    public Long getMatchSeasonId() {
        return season_id;
    }

    public void setMatchSeasonId(Long season_id) {
        this.season_id = season_id;
    }
    
    public Long getMatchResultId() {
        return result_id;
    }

    public void setMatchResultId(Long result_id) {
        
        this.result_id = result_id;
    }
    
    public Byte getMatchRound() {
        return round;
    }

    public void setMatchRound(Byte round) {
        this.round = round;
    }
    
    public Date getMatchDate() {
        return dateMatch;
    }

    public void setMatchDate(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Long getMatchSpectators() {
        return spectators;
    }

    public void setMatchSpectators(Long spectators) {
        this.spectators = spectators;
    }
    
}
