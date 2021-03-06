/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 *
 * @author Ann Johansson
 *
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Arena implements Listable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private int capacity;
    
    
    public Arena(){  
    }

    @Override
    public Long getId() {
        return id;
    }
    
    @Override
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
   
}
