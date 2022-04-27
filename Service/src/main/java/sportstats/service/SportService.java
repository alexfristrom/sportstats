/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Listable;
import sportstats.domain.Sport;
import sportstats.repository.SportRepository;
import sportstats.service.util.CheckId;
import sportstats.service.util.CheckName;
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
        CheckId.checkId(s.getId());
        //String fixedName = CheckName.checkNameContent(s.getName());
        //s.setName(fixedName);
        CheckName.checkName(
                repository.findByName(s.getName()) != null);
          
        return repository.save(s);
    }

    public Sport getSport(Long id) {
        return repository.getById(id);
    }

    public List<Listable> getAllSport() {
        return ListableProxy.listOf(repository.findAll());

    }

}
