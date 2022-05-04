/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Season;
import sportstats.domain.Sport;
import sportstats.domain.Team;
import sportstats.repository.SeasonRepository;
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

    private final TeamRepository teamRepo;
    private final SeasonRepository seasonRepo;
    private final SportRepository sportRepo;

    @Autowired
    public TeamService(TeamRepository repository, SeasonRepository seasonRepo, SportRepository sportRepo) {
        this.teamRepo = repository;
        this.seasonRepo = seasonRepo;
        this.sportRepo = sportRepo;
   
    }

    public Team addSeasonToTeam(String teamName, Long seasonId) {
        Season season = seasonRepo.getById(seasonId);
        System.out.println(teamRepo.countAllTeamsInSeason(seasonId));
        if(teamRepo.countAllTeamsInSeason(seasonId) > 50){
            throw new IndexOutOfBoundsException("There may only be at most 50 teams in a season.");
        }
        Team team = teamRepo.findByName(teamName);
        team.setSeason(season);
        return teamRepo.save(team);
    }

    public Team createTeam(long sportId, Team team) {
        CheckId.checkId(team.getId());
        String fixedName = CheckName.checkNameContent(team.getName());
        team.setName(fixedName);
        Sport sport = sportRepo.findById(sportId).orElseThrow();
        team.setSport(sport);

//        if (team.getSport().getId() == null) {
//            throw new NullPointerException("A team must include a sport");
//        }
        return teamRepo.save(team);

    }
}
       