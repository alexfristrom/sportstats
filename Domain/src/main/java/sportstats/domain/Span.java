/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author max
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Span implements Listable{
    public Span() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String end_date;
    private String start_date;
    
    @Override
    public Long getId(){
        return id;
    }
    public String getStartDate() {
        return start_date;
    }
    public void setStartDate(String date) {
        this.start_date = date;
    }
    public String getEndDate() {
        return end_date;
    }
    public void setEndDate(String date) {
        this.end_date= date;
    }
}
