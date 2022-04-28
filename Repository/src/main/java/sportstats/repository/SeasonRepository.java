/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.Season;

/**
 *
 * @author annjohansson
 */
@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    @Query("FROM Season season WHERE season.league.id = ?1")
    List<Season> listByLeague(Long leagueId);
}
