package com.practice.project;

import java.util.stream.IntStream;

public class PalindromeChallenge {
    public static boolean isPalindrome(String str){
        if (str == null){
            return false;
        }
        // Convert to lowercase, keep only alphanumeric, and check palindrome
        String cleanStr = str.toLowerCase().replaceAll("[^~a-z0-9]", "");
        return IntStream.range(0, cleanStr.length()/2)
                .allMatch(i-> cleanStr.charAt(i)== cleanStr.charAt(cleanStr.length()-1-i));
    }
}
