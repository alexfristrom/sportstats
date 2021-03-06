/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import sportstats.domain.Result;

/**
 *
 * @author annjohansson
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{
    
    
    
}
