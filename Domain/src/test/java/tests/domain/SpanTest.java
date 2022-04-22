package tests.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Span;
import sportstats.handler.DateHandler;

/**
 *
 * @author max
 */
public class SpanTest {

    @Test
    public void testSpanSetGetStartDate(){
        Span span = new Span();
        DateHandler handler = new DateHandler();
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        span.setStartDate(handler.getDate());
        assertEquals(handler.getDate(), span.getStartDate()); 
    }
    
    @Test
    public void testSpanSetGetEndDate(){
        Span span = new Span();
        DateHandler handler = new DateHandler();
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        span.setStartDate(handler.getDate());
        assertEquals(handler.getDate(), span.getStartDate()); 
    }
    
}
