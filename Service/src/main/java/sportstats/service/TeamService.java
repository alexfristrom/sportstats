/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Sport;
import sportstats.domain.Team;
import sportstats.repository.SportRepository;
import sportstats.repository.TeamRepository;
import sportstats.service.util.CheckId;
import sportstats.service.util.CheckName;

/**
 *
 * @author annjohansson
 */
@Service
public class TeamService {
    
    private Team temp;

    private final TeamRepository repository;
    private final SportRepository sportRepository;

    @Autowired
    public TeamService(TeamRepository repository, SportRepository sportRepository) {
        this.repository = repository;
        this.sportRepository = sportRepository;
    }

    public Team saveTeam(Team team) {
//        temp = repository.save(team);
//        sportRepository.findById(sportId).orElseThrow();
//        CheckId.checkId(team.getId());
//        String fixedName = CheckName.checkNameContent(team.getName());
//        team.setName(fixedName);
 
        return repository.save(team);
    }
}
