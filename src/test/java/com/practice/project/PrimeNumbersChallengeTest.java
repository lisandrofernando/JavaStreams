package com.practice.project;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumbersChallengeTest {

    private final PrimeNumbersChallenge PrimeNumbers;
    private static final Logger logger = LogManager.getLogger(PrimeNumbersChallengeTest.class);


    public PrimeNumbersChallengeTest(){
        PrimeNumbers =  new PrimeNumbersChallenge();
    }
    @Test
    @DisplayName("Test isPrime with prime number")
    @Description("Verify 17 is prime")
    public void testIsPrimeTrue() {
        long n = 17;
        logger.info("Starting testIsPrimeTrue with n: {}", n);
        boolean result = PrimeNumbers.isPrime(n);
        logger.info("testIsPrimeTrue result: {}", result);
        assertTrue(result, "Expected 17 to be prime");
    }

    @Test
    @DisplayName("Test isPrime with non-prime number")
    @Description("Verify 15 is not prime")
    public void testIsPrimeFalse() {
        long n = 15;
        logger.info("Starting testIsPrimeFalse with n: {}", n);
        boolean result = PrimeNumbers.isPrime(n);
        logger.info("testIsPrimeFalse result: {}", result);
        assertFalse(result, "Expected 15 to be non-prime");
    }

    @Test
    @DisplayName("Test isPrime with 2")
    @Description("Verify 2 is prime")
    public void testIsPrimeTwo() {
        long n = 2;
        logger.info("Starting testIsPrimeTwo with n: {}", n);
        boolean result = PrimeNumbers.isPrime(n);
        logger.info("testIsPrimeTwo result: {}", result);
        assertTrue(result, "Expected 2 to be prime");
    }

    @Test
    @DisplayName("Test isPrime with 1")
    @Description("Verify 1 is not prime")
    public void testIsPrimeOne() {
        long n = 1;
        logger.info("Starting testIsPrimeOne with n: {}", n);
        boolean result = PrimeNumbers.isPrime(n);
        logger.info("testIsPrimeOne result: {}", result);
        assertFalse(result, "Expected 1 to be non-prime");
    }

    @Test
    @DisplayName("Test isPrime with negative number")
    @Description("Verify negative input throws IllegalArgumentException")
    public void testIsPrimeNegative() {
        long n = -5;
        logger.info("Starting testIsPrimeNegative with n: {}", n);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PrimeNumbers.isPrime(n);
        }, "Expected IllegalArgumentException for negative input");
        logger.info("testIsPrimeNegative exception: {}", exception.getMessage());
        assertEquals("Input must be non-negative", exception.getMessage());
    }

    @Test
    @DisplayName("Test generatePrimes up to 10")
    @Description("Verify primes up to 10 are [2, 3, 5, 7]")
    public void testGeneratePrimesSmall() {
        int limit = 10;
        logger.info("Starting testGeneratePrimesSmall with limit: {}", limit);
        List<Integer> result = PrimeNumbers.generatePrimes(limit);
        logger.info("testGeneratePrimesSmall result: {}", result);
        assertEquals(Arrays.asList(2, 3, 5, 7), result, "Expected [2, 3, 5, 7]");
    }

    @Test
    @DisplayName("Test generatePrimes up to 30")
    @Description("Verify primes up to 30 are [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]")
    public void testGeneratePrimesMedium() {
        int limit = 30;
        logger.info("Starting testGeneratePrimesMedium with limit: {}", limit);
        List<Integer> result = PrimeNumbers.generatePrimes(limit);
        logger.info("testGeneratePrimesMedium result: {}", result);
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), result,
                "Expected [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]");
    }

    @Test
    @DisplayName("Test generatePrimes with limit 1")
    @Description("Verify primes up to 1 returns empty list")
    public void testGeneratePrimesOne() {
        int limit = 1;
        logger.info("Starting testGeneratePrimesOne with limit: {}", limit);
        List<Integer> result = PrimeNumbers.generatePrimes(limit);
        logger.info("testGeneratePrimesOne result: {}", result);
        assertTrue(result.isEmpty(), "Expected empty list");
    }

    @Test
    @DisplayName("Test generatePrimes with negative limit")
    @Description("Verify negative limit throws IllegalArgumentException")
    public void testGeneratePrimesNegative() {
        int limit = -1;
        logger.info("Starting testGeneratePrimesNegative with limit: {}", limit);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PrimeNumbers.generatePrimes(limit);
        }, "Expected IllegalArgumentException for negative limit");
        logger.info("testGeneratePrimesNegative exception: {}", exception.getMessage());
        assertEquals("Limit must be positive", exception.getMessage());
    }
    
}
