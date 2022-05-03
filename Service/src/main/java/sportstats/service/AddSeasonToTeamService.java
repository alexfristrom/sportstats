/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Season;
import sportstats.domain.Team;
import sportstats.repository.TeamRepository;

/**
 *
 * @author David Sjöblom
 */
@Service
public class AddSeasonToTeamService {

    private final TeamRepository repository;

    @Autowired
    public AddSeasonToTeamService(TeamRepository repository) {
        this.repository = repository;
    }
    
    public void addSeasonToTeam(Team team,Season season){
        team.setSeason(season);
    }
    
    
    
    

}
