/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.Arena;

/**
 *
 * @author annjohansson
 */
@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long>{
    
     @Query(value = "SELECT name FROM arena WHERE name = ?1",nativeQuery = true)
    String findByName(String name);
}
