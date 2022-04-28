/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sportstats.domain;

import java.io.Serializable;

/**
 *
 * @author David Sjöblom
 */
public interface Listable extends Serializable {
    
    public Long getId();
    
    public String getName();
    
}
