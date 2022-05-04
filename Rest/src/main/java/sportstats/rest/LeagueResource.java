/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.League;
import sportstats.domain.Listable;
import sportstats.service.LeagueService;
import sportstats.service.util.LeagueBySport;

/**
 * Servlet class for Leagueservice
 * 
 * @author alexf
 */

@RestController
@RequestMapping("league")
public class LeagueResource {
    
    private final LeagueService service;
    
    @Autowired
    public LeagueResource(LeagueService service){
        this.service = service;
    }
    
    @PostMapping("/{sportId}/{leagueName}")
    public League saveLeague(@PathVariable Long sportId, @PathVariable String leagueName){
        return service.saveLeague(sportId, leagueName);
    }
    
    @GetMapping("listBySport/{sportId}")
    public List<LeagueBySport> listBySport(@PathVariable Long sportId){
        return service.listBySport(sportId);
    }
    
    @GetMapping
    public List<Listable> getAllLeague(){
        return service.getAllLeague();
    }
    
}
