package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 * @author danielw
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Result implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hometeam_score;

    private Long awayteam_score;

    private boolean overtime;

    private boolean penalties;

    private Long overtime_minutes;

    public Result() {
    }

    public Result(Long id, Long hometeam_score, Long awayteam_score) {
        this.id = id;
        this.hometeam_score = hometeam_score;
        this.awayteam_score = awayteam_score;
    }

    public Long getId() {
        return id;
    }

    public Long getHomeTeamScore() {
        return hometeam_score;
    }

    public void setHomeTeamScore(Long hometeam_score) {
        this.hometeam_score = hometeam_score;
    }

    public Long getAwayTeamScore() {
        return awayteam_score;
    }

    public void setAwayTeamScore(Long awayteam_score) {
        this.awayteam_score = awayteam_score;
    }

    public boolean getPenalty() {
        return penalties;
    }

    public void setPenalty(boolean penalties) {
        this.penalties = penalties;
    }

    public boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(boolean overtime) {

        this.overtime = overtime;
    }

    public Long getOvertimeMinutes() {
        return overtime_minutes;
    }

    public void setOvertimeMinutes(Long overtime_minutes) {
        this.overtime_minutes = overtime_minutes;
    }

}
