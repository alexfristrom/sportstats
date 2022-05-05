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
    List<Game> listByTeam(Long teamId);
}
