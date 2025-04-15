package com.practice.project;


import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestPalindromicSubstringTest {

    private static final Logger logger = LogManager.getLogger(LongestPalindromicSubstringTest.class);
    private final LongestPalindromicSubstringChallenge LongestPalindrome;

    public LongestPalindromicSubstringTest(){
        LongestPalindrome = new LongestPalindromicSubstringChallenge();
    }



    @Test
    @DisplayName("Test basic palindrome substring")
    @Description("Verify longest palindrome for 'babad' is 'bab' or 'aba'")
    public void testBasicPalindrome() {
        String input = "babad";
        logger.info("Starting testBasicPalindrome with input: {}", input);
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testBasicPalindrome result: {}", result);
        assertTrue("bab".equals(result) || "aba".equals(result), "Expected 'bab' or 'aba', got " + result);
    }

    @Test
    @DisplayName("Test double character palindrome")
    @Description("Verify longest palindrome for 'cbbd' is 'bb'")
    public void testDoubleCharPalindrome() {
        String input = "cbbd";
        logger.info("Starting testDoubleCharPalindrome with input: {}", input);
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testDoubleCharPalindrome result: {}", result);
        assertEquals("bb", result, "Expected 'bb', got " + result);
    }

    @Test
    @DisplayName("Test empty string")
    @Description("Verify longest palindrome for empty string is ''")
    public void testEmptyString() {
        String input = "";
        logger.info("Starting testEmptyString with input: ''");
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testEmptyString result: {}", result);
        assertEquals("", result, "Expected '', got " + result);
    }

    @Test
    @DisplayName("Test null input")
    @Description("Verify longest palindrome for null is ''")
    public void testNullString() {
        logger.info("Starting testNullString with input: null");
        String result = LongestPalindrome.longestPalindrome(null);
        logger.info("testNullString result: {}", result);
        assertEquals("", result, "Expected '', got " + result);
    }

    @Test
    @DisplayName("Test single character")
    @Description("Verify longest palindrome for 'a' is 'a'")
    public void testSingleCharacter() {
        String input = "a";
        logger.info("Starting testSingleCharacter with input: {}", input);
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testSingleCharacter result: {}", result);
        assertEquals("a", result, "Expected 'a', got " + result);
    }

    @Test
    @DisplayName("Test no palindrome")
    @Description("Verify longest palindrome for 'abc' is 'a' or 'b' or 'c'")
    public void testNoPalindrome() {
        String input = "abc";
        logger.info("Starting testNoPalindrome with input: {}", input);
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testNoPalindrome result: {}", result);
        assertTrue("a".equals(result) || "b".equals(result) || "c".equals(result),
                "Expected 'a' or 'b' or 'c', got " + result);
    }

    @Test
    @DisplayName("Test full palindrome")
    @Description("Verify longest palindrome for 'racecar' is 'racecar'")
    public void testFullPalindrome() {
        String input = "racecar";
        logger.info("Starting testFullPalindrome with input: {}", input);
        String result = LongestPalindrome.longestPalindrome(input);
        logger.info("testFullPalindrome result: {}", result);
        assertEquals("racecar", result, "Expected 'racecar', got " + result);
    }

}
