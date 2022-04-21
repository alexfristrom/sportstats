/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.handler.DateHandler;

/**
 * Test for handler of LocalDate/Time Involves test for Metohds for LocalDate,
 * LocalTime and LocalDateTime
 *
 * @author alexf
 */
public class DateHandlerTest {

    @Test
    public void testDate() {
        DateHandler handler = new DateHandler();
        handler.addDate(2022, 5, 15);
        LocalDate date = handler.getDate();

        LocalDate refferenceDate = LocalDate.of(2022, 5, 15);
        assertEquals(refferenceDate, date);

        System.out.println("Date: " + date);

    }

    @Test
    public void testTime() {
        DateHandler handler = new DateHandler();
        handler.addTime(20, 15, 0);
        LocalTime time = handler.getTime();

        LocalTime refferenceTime = LocalTime.of(20, 15, 0);
        assertEquals(refferenceTime, time);

        System.out.println("Time: " + time);
    }

    @Test
    public void testDateTime() {
        DateHandler handler = new DateHandler();
        handler.addTime(20, 15, 0);
        handler.addDate(2022, 5, 15);
        LocalDateTime dateTime = handler.getDateTime();

        LocalDateTime refferenceDateTime = LocalDateTime.of(2022, 5, 15, 20, 15, 0);
        assertEquals(refferenceDateTime, dateTime);

        System.out.println("Date and Time :" + dateTime);

    }

    @Test
    public void getDateExcludeTimeFromDateTime() {
        DateHandler handler = new DateHandler();
        handler.addTime(20, 15, 0);
        handler.addDate(2022, 5, 15);
        LocalDateTime dateTime = handler.getDateTime();
        
        LocalDate refferenceDate = LocalDate.of(2022, 5, 15);
        LocalDate date = dateTime.toLocalDate();
        assertEquals(refferenceDate, date);
        
        System.out.println("Date only from DateTime: " + date);
    }
    
    @Test
    public void getTimeExcludeDateFromDateTime(){
        DateHandler handler = new DateHandler();
        handler.addTime(20, 15, 0);
        handler.addDate(2022, 5, 15);
        LocalDateTime dateTime = handler.getDateTime();
        
        LocalTime refferenceTime = LocalTime.of(20, 15, 0);
        LocalTime time = dateTime.toLocalTime();
        assertEquals(refferenceTime, time);
        
        System.out.println("Time only from DateTime: " + time);
    }
    
    @Test
    public void test(){
        
    }

}
