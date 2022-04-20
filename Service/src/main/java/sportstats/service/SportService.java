/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Sport;
import sportstats.repository.SportRepository;

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
        return repository.save(s);
    }
    
    public Sport getSport(Long id) {
        return repository.getById(id);
    }
    
    public List<Sport> getAll() {
        return repository.findAll();
    }

}
