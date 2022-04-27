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
import sportstats.service.LeagueService;
import sportstats.service.util.LeagueBySport;

/**
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
    
    @PostMapping("{sportId}")
    public League saveLeague(@PathVariable Long sportId){
        return service.saveLeague(sportId);
    }
    
    @GetMapping("sport/{sportId}")
    public List<LeagueBySport> listByRoom(@PathVariable Long sportId){
        return service.listBySport(sportId);
    }
    
}
