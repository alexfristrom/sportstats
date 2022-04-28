/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.League;

/**
 * Egen Query metod för att kunna söka efter specfik data
 * 
 * @author annjohansson
 */
@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    @Query("FROM League league WHERE league.sport.id = ?1")
    List<League> listBySport(Long sportId);

}
