/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.util.List;
import sportstats.domain.Listable;

/**
 *
 * @author alexf
 */
public class ListableProxy implements Listable{
    
    private final Listable delegate;
    
    public ListableProxy(Listable delegate){
        this.delegate = delegate;
    }

    @Override
    public Long getId() {
        return delegate.getId();
    }
    
    @Override
    public String getName(){
        return delegate.getName();
    }
    
    public static List<Listable> listOf(List<? extends Listable> source){
        return source.stream()
                .map(p ->(Listable) new ListableProxy(p))
                .toList();
    }
    
}
