/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.Game;

/**
 *
 * @author annjohansson
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    
    @Query("FROM Game game WHERE game.hometeam.id = ?1 OR game.awayteam.id = ?1")
    List<Game> listAllByTeam(Long teamId);
    
    @Query("FROM Game game WHERE game.awayteam.id = ?1")
    List<Game> listAwayByTeam(Long teamId);
    
    @Query("FROM Game game WHERE game.hometeam.id = ?1")
    List<Game> listHomeByTeam(Long teamId);
    
    @Query(value = "SELECT count(*) FROM game WHERE round = ?1 AND hometeam_id = ?2",nativeQuery = true)
    public int checkIfHomeTeamAlreadyHaveMatchInRound(Byte round,Long teamId);
    
    @Query(value = "SELECT count(*) FROM game WHERE round = ?1 AND awayteam_id = ?2",nativeQuery = true)
    public int checkIfAwayTeamAlreadyHaveMatchInRound(Byte round,Long teamId);
}
