package com.practice.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class LongestPalindromicSubstringChallenge {

    private static final Logger logger = LogManager.getLogger(LongestPalindromicSubstringChallenge.class);

    public static String longestPalindrome(String s){
        logger.info("Finding longest palindrome for input: {}", s);

        if (s== null || s.isEmpty()){
            logger.warn("Input is null or empty");
            return "";
        }
        // Strean over all possible substring start and end indices
        String longest = IntStream.rangeClosed(0, s.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start, s.length())
                        .mapToObj(end -> s.substring(start, end)))
                .filter(LongestPalindromicSubstringChallenge::isPalindrome)
                .reduce("", (a, b) -> a.length() >= b.length() ? a : b);

        logger.info("Longest palindrome found: {}", longest);
        return longest;
    }

    private static boolean isPalindrome(String str) {
        logger.debug("Checking if '{}' is palindrome", str);
        String cleanStr = str.toLowerCase();
        boolean isPalindrome = IntStream.range(0, cleanStr.length() / 2)
                .allMatch(i -> cleanStr.charAt(i) == cleanStr.charAt(cleanStr.length() - 1 - i));
        logger.debug("Is '{}' a palindrome? {}", str, isPalindrome);
        return isPalindrome;
    }

}
