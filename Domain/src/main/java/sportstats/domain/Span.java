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
    public void setStartDate(int year, int month, int day) {
        start_date = LocalDate.of(year, month, month);
    }
    public LocalDate getEndDate() {
        return end_date;
    }
    public void setEndDate(int year, int month, int day) {
        end_date = LocalDate.of(year, month, day);
    }
}
