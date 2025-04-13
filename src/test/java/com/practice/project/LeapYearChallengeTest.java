package com.practice.project;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeapYearChallengeTest {

    private final LeapYearChallenge leapYear;

    public LeapYearChallengeTest() {
        leapYear = new LeapYearChallenge();
    }
    @Test
    public void testLeapYears(){
        assertTrue(leapYear.isLeapYear(2020));
        assertTrue(leapYear.isLeapYear(2000));
        assertTrue(leapYear.isLeapYear(1600));
    }

    @Test
    public void testNonLeapYear(){
        assertFalse(leapYear.isLeapYear(2019));
        assertFalse(leapYear.isLeapYear(1900));
        assertFalse(leapYear.isLeapYear(2100));
    }

    @Test
    public void testInvalidYear() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> leapYear.isLeapYear(0)
        );
        assertTrue(exception.getMessage().contains("Year must be"),
                "Exception message should mention that year must be >= 1");
    }
}
