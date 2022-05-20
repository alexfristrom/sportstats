/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.service.SeasonSummaryService;
import sportstats.service.season.holders.SeasonSumType;

/**
 *
 * @author alexf
 */
@RestController
@RequestMapping("seasonSummary")
public class SeasonSummaryResource {
    
    private final SeasonSummaryService service;
    
    @Autowired
    public SeasonSummaryResource(SeasonSummaryService service){
        this.service = service;
    }
    
    @GetMapping("getSeasonSummary/{seasonId}")
    public List<SeasonSumType> getSeasonSummary(@PathVariable Long seasonId){
        return service.getSeasonSummary(seasonId);
    } 

    @GetMapping("getSeasonsSummary/{seasonIdInteval}")
    public List<SeasonSumType> getSeasonsSummary(@PathVariable String  seasonIdInteval){
        return service.getSeasonsSummary(seasonIdInteval);
    }
    
    @GetMapping("getSeasonSummaryResultFilter/{seasonId}/{homeOraway}")
    public List<SeasonSumType> getSeasonSummaryResultFilter(@PathVariable Long seasonId
                                    ,@PathVariable String homeOraway){
        return service.getSeasonSummaryResultFilter(seasonId, homeOraway);
    }
    
    @GetMapping("getSeasonSummeryRoundIntervalFilter/{seasonId}/{interval}")
    public List<SeasonSumType> getSeasonSummaryRoundIntervalFilter(@PathVariable Long seasonId
                                    ,@PathVariable String interval){
        return service.getSeasonSummaryRoundFilter(seasonId, interval);
    }
    
}
