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
import sportstats.service.holders.FotballSummaryHolder;
import sportstats.service.holders.SeasonSumHolderType;

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
    public List<SeasonSumHolderType> getSeasonSummary(@PathVariable Long seasonId){
        return service.getSeasonSummary(seasonId);
    }    
}
