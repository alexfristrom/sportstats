/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import org.hibernate.type.LocalDateTimeType;

/**
 *
 * @author alexf
 */
public class DateHandler {
    
    private LocalTime time;
    private LocalDate date;
    private LocalDateTime dateTime;
    
    public DateHandler(){
    }
    
    public void addDate(int year, int month, int day){
        date = LocalDate.of(year, month, day);
    }
    
    public void addTime(int hours, int minute, int seconds){
        time = LocalTime.of(hours, minute, seconds);
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public LocalTime getTime(){
        return this.time;
    }
    
    public LocalDateTime getDateTime(){
        return dateTime = LocalDateTime.of(date, time);
    }
    
}
