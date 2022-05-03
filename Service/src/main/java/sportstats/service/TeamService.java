/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Arena;
import sportstats.domain.Season;
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

    private final TeamRepository repository;

    @Autowired
    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public Team saveTeam(Team team) {
        CheckId.checkId(team.getId());
        String fixedName = CheckName.checkNameContent(team.getName());
        team.setName(fixedName);
        
//        if (team.getSport().getId() == null) {
//            throw new NullPointerException("A team must include a sport");
//        }

        return repository.save(team);
    }
}
