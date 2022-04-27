/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Listable;
import sportstats.domain.Sport;
import sportstats.repository.SportRepository;
import sportstats.service.util.ListableProxy;

/**
 *
 * @author annjohansson
 */
@Service
public class SportService {
    private final SportRepository repository;
            
    @Autowired
    public SportService(SportRepository repository) {
        this.repository = repository;
    }

     public Sport saveSport(Sport s) {
        if (s.getId() != null) {
            throw new ServiceException("New Sport object can not have ID prior to persistence");
        }
        if(this.isUnique(s) != null){
              throw new ServiceException("Dubplcate name!");
        }
        return repository.save(s);
    }
    
    public Sport getSport(Long id) {
        return repository.getById(id);
    }
    
    public List<Listable> getAllSport() {
        return ListableProxy.listOf(repository.findAll());       
                
    }
    
    public String isUnique(Sport s){
        return repository.isUnique(s.getName());
        
    }
}
