/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.League;
import sportstats.domain.Listable;
import sportstats.domain.Sport;
import sportstats.repository.LeagueRepository;
import sportstats.repository.SportRepository;
import sportstats.service.util.LeagueBySport;
import sportstats.service.util.ListableProxy;

/**
 * Functions for that refclets the backlog for league
 *
 * @author alexf
 */
@Service
public class LeagueService {

    private Sport sport;
    private League league;

    private LeagueRepository repository;
    private SportRepository sportRepository;

    @Autowired
    public LeagueService(LeagueRepository repository, SportRepository sportRepository) {
        this.repository = repository;
        this.sportRepository = sportRepository;
    }

    public League saveLeague(Long sportId, String name) {
        sport = sportRepository.getById(sportId);
        league = new League(sport);
        league.setName(name);
        return repository.save(league);
    }

    public List<LeagueBySport> listBySport(Long sportId) {
        return repository.listBySport(sportId).stream()
                .map(LeagueBySport::new)
                .toList();
    }

    public List<Listable> getAllLeague() {
        return ListableProxy.listOf(repository.findAll());

    }

}
