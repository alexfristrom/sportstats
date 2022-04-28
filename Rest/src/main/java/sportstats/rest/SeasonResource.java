/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.League;
import sportstats.domain.Listable;
import sportstats.domain.Season;
import sportstats.service.LeagueService;
import sportstats.service.SeasonService;
import sportstats.service.util.LeagueBySport;
import sportstats.service.util.SeasonByLeague;

/**
 * Servlet class for Leagueservice
 * 
 * @author alexf
 */

@RestController
@RequestMapping("season")
public class SeasonResource {
    
    private final SeasonService service;
    
    @Autowired
    public SeasonResource(SeasonService service){
        this.service = service;
    }
    
    @PostMapping("/{roundTot}/{leagueId}/{spanId}")
    public Season saveSeason(@PathVariable int roundTot, @PathVariable Long leagueId, @PathVariable Long spanId){
        return service.saveSeason(roundTot, leagueId, spanId);
    }
    
    @GetMapping("listByLeague/{leagueId}")
    public List<SeasonByLeague> listByLeague(@PathVariable Long leagueId){
        return service.listByLeague(leagueId);
    }
    
    @GetMapping
    public List<Season> getAllSeason(){
        return service.getAllSeason();
    }
    
}
