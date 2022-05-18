/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import sportstats.domain.Game;
import sportstats.repository.GameRepository;
import sportstats.repository.SeasonRepository;

/**
 *
 * @author max
 */
public class GameByDateAndLeague {
    
    private Game delegate;
    
    public GameByDateAndLeague(Game delegate){
        this.delegate = delegate;
    }
    
}
