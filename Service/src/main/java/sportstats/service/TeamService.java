/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Season;
import sportstats.domain.Team;
import sportstats.repository.SeasonRepository;
import sportstats.repository.TeamRepository;

/**
 *
 * @author David Sjöblom
 */
@Service
public class TeamService {

    private final TeamRepository teamRepo;
    private final SeasonRepository seasonRepo;

    @Autowired
    public TeamService(TeamRepository teamRepo,SeasonRepository seasonRepo) {
        this.teamRepo = teamRepo;
        this.seasonRepo = seasonRepo;
    }
    
    public Team addSeasonToTeam(String teamName,Long seasonId){
        Season season = seasonRepo.getById(seasonId);
        Team team = teamRepo.findByName(teamName);
        team.setSeason(season);
        return teamRepo.save(team);
    }
    
    
    
    

}
