package com.practice.project;

public class LeapYearChallenge {

    public static boolean isLeapYear(int year){
        if (year<1) {
            throw new IllegalArgumentException("Year must be >=1");
        }
        return (year % 4 == 0 && year % 100 !=0) || (year % 400==0);
    }
}
