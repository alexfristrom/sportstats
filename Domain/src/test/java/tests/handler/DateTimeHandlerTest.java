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
import sportstats.handler.DateTimeHandler;

/**
 * Test for handler of LocalDate/Time Involves test for Metohds for LocalDate,
 * LocalTime and LocalDateTime
 *
 * @author alexf
 */
public class DateTimeHandlerTest {

    @Test
    public void testDate() {
        DateTimeHandler handler = new DateTimeHandler();
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        LocalDate date = handler.getDate();

        LocalDate refferenceDate = LocalDate.of(2022, 5, 15);
        assertEquals(refferenceDate, date);

        System.out.println("Date: " + date);

    }

    @Test
    public void testTime() {
        DateTimeHandler handler = new DateTimeHandler();
        byte hour = 20;
        byte minute = 15;
        byte second = 0;
        handler.addTime(hour, minute, second);
        LocalTime time = handler.getTime();

        LocalTime refferenceTime = LocalTime.of(20, 15, 0);
        assertEquals(refferenceTime, time);

        System.out.println("Time: " + time);
    }

    @Test
    public void testDateTime() {
        DateTimeHandler handler = new DateTimeHandler();
        byte hour = 20;
        byte minute = 15;
        byte second = 0;
        handler.addTime(hour, minute, second);
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        LocalDateTime dateTime = handler.getDateTime();

        LocalDateTime refferenceDateTime = LocalDateTime.of(2022, 5, 15, 20, 15, 0);
        assertEquals(refferenceDateTime, dateTime);

        System.out.println("Date and Time :" + dateTime);

    }

    @Test
    public void getDateExcludeTimeFromDateTime() {
        DateTimeHandler handler = new DateTimeHandler();
        byte hour = 20;
        byte minute = 15;
        byte second = 0;
        handler.addTime(hour, minute, second);
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        LocalDateTime dateTime = handler.getDateTime();

        LocalDate refferenceDate = LocalDate.of(2022, 5, 15);
        LocalDate date = dateTime.toLocalDate();
        assertEquals(refferenceDate, date);

        System.out.println("Date only from DateTime: " + date);
    }

    @Test
    public void getTimeExcludeDateFromDateTime() {
        DateTimeHandler handler = new DateTimeHandler();
        byte hour = 20;
        byte minute = 15;
        byte second = 0;
        handler.addTime(hour, minute, second);
        short year = 2022;
        byte month = 5;
        byte day = 15;
        handler.addDate(year, month, day);
        LocalDateTime dateTime = handler.getDateTime();

        LocalTime refferenceTime = LocalTime.of(20, 15, 0);
        LocalTime time = dateTime.toLocalTime();
        assertEquals(refferenceTime, time);

        System.out.println("Time only from DateTime: " + time);
    }

    @Test
    public void exceptionThrowTime() {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    byte hour = 25;
                    byte minute = 15;
                    byte second = 0;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addTime(hour, minute, second);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    byte hour = 24;
                    byte minute = -2;
                    byte second = 0;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addTime(hour, minute, second);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    byte hour = 23;
                    byte minute = 15;
                    byte second = 70;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addTime(hour, minute, second);
                });
    }
     @Test
    public void exceptionThrowDate() {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    short year = 25;
                    byte month = 12;
                    byte day = 1;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addDate(year, month, day);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    short year = 2000;
                    byte month = 14;
                    byte day = 1;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addDate(year, month, day);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    short year = 2000;
                    byte month = 11;
                    byte day = 0;
                    DateTimeHandler dateHandler = new DateTimeHandler();
                    dateHandler.addDate(year, month, day);
                });
    }
}
