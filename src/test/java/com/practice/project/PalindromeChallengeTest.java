package com.practice.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeChallengeTest {

    private final PalindromeChallenge checkPalindrome;

    public PalindromeChallengeTest(){
        checkPalindrome = new PalindromeChallenge();
    }

    @Test
    public void testBasicPalindrome() {
        assertTrue(checkPalindrome.isPalindrome("racecar"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(checkPalindrome.isPalindrome(""));
    }

    @Test
    public void testNullString() {
        assertFalse(checkPalindrome.isPalindrome(null));
    }

    @Test
    public void testNonPalindrome() {
        assertFalse(checkPalindrome.isPalindrome("hello"));
    }

    @Test
    public void testPalindromeWithSpacesAndPunctuation() {
        assertTrue(checkPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(checkPalindrome.isPalindrome("a"));
    }

    @Test
    public void testMixedCasePalindrome() {
        assertTrue(checkPalindrome.isPalindrome("RaCeCaR"));
    }

    @Test
    public void testNonPalindromeWithSpaces() {
        assertFalse(checkPalindrome.isPalindrome("not a palindrome"));
    }
}
