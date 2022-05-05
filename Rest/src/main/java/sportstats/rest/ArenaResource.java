/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Arena;
import sportstats.domain.Listable;
import sportstats.service.ArenaService;

/**
 *
 * @author annjohansson
 */
@RestController
@RequestMapping("arena")
public class ArenaResource {
    
      private final ArenaService service;
    
    @Autowired
    public ArenaResource(ArenaService service){
        this.service = service;
    }
    
    @PostMapping
    public Arena saveArena(@RequestBody Arena arena){
        return service.saveArena(arena);
    }
    
    @GetMapping("{id}")
    public Arena getArenaById(@PathVariable Long id){
        return service.getArena(id);
    }
    
    @GetMapping
    public List<Listable> getAllArena(){
        return service.getAllArena();
    }
}
