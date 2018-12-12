package com.arkt.clother.Services;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeServiceTest {

    @Test
    public void correctDataToTime() {
        String time = TimeService.unixTimeStampToTime(1544128744);
        assertEquals("22:39", time);
    }

    @Test
    public void correctDataToDayOfWeek() {
        String time = TimeService.unixTimeStampToDayOfWeek(1544128744);
        assertEquals("Thu", time);
    }
}