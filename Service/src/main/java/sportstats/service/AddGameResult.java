/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sportstats.repository.GameRepository;

/**
 *
 * @author alexf
 */
@Service
public class AddGameResult {
    
    private GameRepository gameR;
    
    @Autowired
    public AddGameResult(GameRepository gameRepository){
        this.gameR = gameRepository;
    }
    
    
    
}
