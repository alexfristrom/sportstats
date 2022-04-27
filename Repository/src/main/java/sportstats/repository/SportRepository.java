/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sportstats.domain.Sport;

/**
 *
 * @author annjohansson
 */
@Repository
public interface SportRepository extends JpaRepository<Sport, Long>{

    @Query("FROM Sport s WHERE name CONCAT(?1,'%') ")
    String isUnique(String name);

}
