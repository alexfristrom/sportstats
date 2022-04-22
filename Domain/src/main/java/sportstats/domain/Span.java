/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
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
    private LocalDate end_date;
    private LocalDate start_date;
    
    @Override
    public Long getId(){
        return id;
    }
    public LocalDate getStartDate() {
        return start_date;
    }
    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }
    public LocalDate getEndDate() {
        return end_date;
    }
    public void setEndDate(LocalDate end_date) {
        this.end_date = end_date;
    }
}
