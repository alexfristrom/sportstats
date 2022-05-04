/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Team;
import sportstats.service.TeamService;

/**
 *
 * @author David Sjöblom
 */
@RestController
@RequestMapping("team")
public class TeamResource {
    private final TeamService service;
    
    @Autowired
    public TeamResource(TeamService service){
        this.service = service;
    }
    
//    @PostMapping("/{sportId}/{teamName}")
//    public Team saveTeam(@PathVariable Long sportId, @PathVariable String name){
//        
//        return service.saveTeam(sportId, name);
//    }
    
    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return service.saveTeam(team);
    }
}
