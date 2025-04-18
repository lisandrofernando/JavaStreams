package com.practice.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbersChallenge {

    private static final Logger logger = LogManager.getLogger(PrimeNumbersChallenge.class);

    /**
     * Checks if a number is prime.
     * @param n Number to check (non-negative)
     * @return true if n is prime, false otherwise
     * @throws IllegalArgumentException if n is negative
     */
    public static boolean isPrime(long n) {
        logger.info("Checking if {} is prime", n);

        if (n < 0) {
            logger.error("Negative input: {}", n);
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            logger.debug("Input {} is not prime (≤ 1)", n);
            return false;
        }
        if (n == 2) {
            logger.debug("Input 2 is prime");
            return true;
        }
        if (n % 2 == 0) {
            logger.debug("Input {} is even and not prime", n);
            return false;
        }

        // Check odd divisors up to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                logger.debug("Input {} is divisible by {}, not prime", n, i);
                return false;
            }
        }

        logger.info("Input {} is prime", n);
        return true;
    }

    /**
     * Generates all prime numbers up to a given limit using Sieve of Eratosthenes.
     * @param limit Upper bound (inclusive, positive)
     * @return List of primes up to limit
     * @throws IllegalArgumentException if limit is less than 1
     */
    public static List<Integer> generatePrimes(int limit) {
        logger.info("Generating primes up to {}", limit);

        if (limit < 1) {
            logger.error("Invalid limit: {}", limit);
            throw new IllegalArgumentException("Limit must be positive");
        }

        // Initialize sieve
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        if (limit >= 2) {
            isPrime[2] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 3; i <= Math.sqrt(limit); i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // Mark even numbers > 2 as non-prime
        for (int i = 4; i <= limit; i += 2) {
            isPrime[i] = false;
        }

        // Collect primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        logger.info("Found {} primes: {}", primes.size(), primes);
        return primes;
    }

}
