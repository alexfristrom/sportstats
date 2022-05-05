/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.domain.Arena;
import sportstats.domain.Listable;
import sportstats.repository.ArenaRepository;
import sportstats.service.util.CheckId;
import sportstats.service.util.CheckName;
import sportstats.service.util.ListableProxy;

/**
 *
 * @author annjohansson
 */
@Service
public class ArenaService {

    private final ArenaRepository repository;

    @Autowired
    public ArenaService(ArenaRepository repository) {
        this.repository = repository;
    }
     public Arena saveArena(Arena arena) {
        CheckId.checkId(arena.getId());
        String fixedName = CheckName.checkNameContent(arena.getName());
        arena.setName(fixedName);
        CheckName.checkName(
                repository.findByName(arena.getName()) != null);
          
        return repository.save(arena);
    }

    public Arena getArena(Long id) {
        return repository.getById(id);
    }

    public List<Listable> getAllArena() {
        return ListableProxy.listOf(repository.findAll());

    }

}
