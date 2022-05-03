/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.service.AddSeasonToTeamService;

/**
 *
 * @author David Sjöblom
 */
@RestController
@RequestMapping("team")
public class TeamResource {
    private final AddSeasonToTeamService service;
    
    @Autowired
    public TeamResource(AddSeasonToTeamService service){
        this.service = service;
    }
    
    @PostMapping("/{seasonId}/{teamName}")
    public Team addSeasonToTeam(@PathVariable Long seasonId,@PathVariable )
}
