/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.League;
import sportstats.domain.Listable;
import sportstats.domain.Season;
import sportstats.domain.Span;

import sportstats.repository.LeagueRepository;
import sportstats.repository.SeasonRepository;
import sportstats.repository.SpanRepository;

import sportstats.service.util.LeagueBySport;
import sportstats.service.util.ListableProxy;
import sportstats.service.util.SeasonByLeague;

/**
 * Functions for that refclets the backlog for league 
 *
 * @author alexf
 */
@Service
public class SeasonService {
    private Season season;
    private League league;
    private Span span;
    
    private SpanRepository spanRepository;
    private LeagueRepository leagueRepository;
    private SeasonRepository repository;
    
    @Autowired
    public SeasonService(LeagueRepository leagueRepository, SeasonRepository repository, SpanRepository spanRepository){
        this.repository = repository;
        this.leagueRepository = leagueRepository;
        this.spanRepository = spanRepository;
    }
    //fixa i efterhand
    public Season saveSeason(int roundTot, Long leagueId, Long spanId){
         league = leagueRepository.getById(leagueId);
         span = spanRepository.getById(spanId);
        season = new Season(roundTot, league, span);
        return repository.save(season);
    }
    
    public List<SeasonByLeague> listByLeague(Long leagueId){
        return repository.listByLeague(leagueId).stream()
                .map(SeasonByLeague::new)
                .toList();
    }
    
    public List<Season> getAllSeason() {
        return repository.findAll();       
                
    }
    
    
    
    
    
    
    
}
