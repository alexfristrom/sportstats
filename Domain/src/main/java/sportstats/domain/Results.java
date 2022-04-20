package sportstats.domain;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
/**
 * FIXA BOOLEAN GETTERS NÄR DATABASEN ÄR KLAR
 * @author danielw
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Results implements Listable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long hometeam_score;
    
    private Long awayteam_score;
    
    //  private boolean overtime;
    
   //   private boolean penalties;
    
    private Long overtime_minutes;
    
    public Results() {
    }

    public Results(Long id, Long hometeam_score, Long awayteam_score) {
        this.id = id;
        this.hometeam_score = hometeam_score;
        this.awayteam_score = awayteam_score;
    }

    @Override
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
    
//    public boolean getResultPenalties() {
//        return penalties;
//    }
//
//    public void setResultPenalties(boolean penalties) {
//        this.penalties = penalties;
//    }
//    
//    public boolean getResultOvertime() {
//        return overtime;
//    }
//
//    public void setResultOvertime(boolean overtime) {
//        
//        this.overtime = overtime;
//    }
    
    public Long getResultOvertimeMinutes() {
        return overtime_minutes;
    }

    public void setResultOvertimeMinutes(Long overtime_minutes) {
        this.overtime_minutes = overtime_minutes;
    }

    
}