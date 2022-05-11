/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.Team;

/**
 *
 * @author annjohansson
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    @Query(value = "SELECT * FROM team WHERE name = ?1",nativeQuery = true)
    public Team findByName(String teamName);
    
    @Query(value = "SELECT count(*) FROM team WHERE season_id = ?1",nativeQuery = true)
    public int countAllTeamsInSeason(Long season_id);
    
    @Query(value = "FROM Team team WHERE season_id = ?1")
    List<Team> listBySeason(Long season_id);
    
    
}
