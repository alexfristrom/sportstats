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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Listable;
import sportstats.domain.Sport;
import sportstats.service.SportService;

/**
 *
 * @author alexf
 */

@RestController
@RequestMapping("sport")
public class SportResource {
    
    private final SportService service;
    
    @Autowired
    public SportResource(SportService service){
        this.service = service;
    }
    
    @PostMapping
    public Sport saveSport(@RequestBody Sport sport){
        return service.saveSport(sport);
    }
    
    @GetMapping("{id}")
    public Sport getSportById(@PathVariable Long id){
        return service.getSport(id);
    }
    
    @GetMapping
    public List<Listable> getAllSport(){
        return service.getAllSport();
    }
    
}
