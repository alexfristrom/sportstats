/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author alexf
 */
public class DateTimeHandler {

    private LocalTime time;
    private LocalDate date;
    private LocalDateTime dateTime;

    public DateTimeHandler() {
    }

    public DateTimeHandler(short year, byte month, byte day) {
        this.addDate(year, month, day);
    }
    
    public DateTimeHandler(byte hour, byte minute, byte second){
        this.addTime(hour, minute, second);
    }
    public DateTimeHandler(short year, byte month, byte day, byte hour, byte minute, byte second) {
        this.addDate(year, month, day);
        this.addTime(hour, minute, second);
    }

    public void addDate(short year, byte month, byte day) {
        if (year < 2000 || year > 2050) {
            throw new IllegalArgumentException("Year can not be below 2000 or above 2050.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month can not be below 1 or above 12.");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day can not be below 1 or above 31.");
        }
        date = LocalDate.of(year, month, day);
    }

    public void addTime(byte hour, byte minute, byte second) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Hour can not be below 0 or above 24.");
        }
        if (minute < 0 || minute > 60) {
            throw new IllegalArgumentException("Minute can not be below 0 or above 60.");
        }
        if (second < 0 || second > 60) {
            throw new IllegalArgumentException("Second can not be below 0 or above 60.");
        }
        time = LocalTime.of(hour, minute, second);
    }

    public LocalDate getDate() {
        if (date == null) {
            throw new NullPointerException("Date have not been initialized.");
        }
        return this.date;
    }

    public LocalTime getTime() {
        if (time == null) {
            throw new NullPointerException("Time have not been initialized.");
        }
        return this.time;
    }

    public LocalDateTime getDateTime() {
        if (date == null) {
            throw new NullPointerException("Date have not been initialized.");
        }
        if (time == null) {
            throw new NullPointerException("Time have not been initialized.");
        }
        return dateTime = LocalDateTime.of(date, time);
    }

}
