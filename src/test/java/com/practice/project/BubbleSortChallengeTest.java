package com.practice.project;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortChallengeTest {
    private static final Logger logger = LogManager.getLogger(BubbleSortChallengeTest.class);
    private final BubbleSortChallenge BubbleSort;

    public BubbleSortChallengeTest(){
        BubbleSort = new BubbleSortChallenge();
    }

        @Test
        @DisplayName("Test bubble sort with unsorted array")
        @Description("Verify sorting of an unsorted array [5, 2, 8, 1, 9]")
        public void testUnsortedArray() {
            int[] input = {5, 2, 8, 1, 9};
            int[] expected = {1, 2, 5, 8, 9};
            logger.info("Starting testUnsortedArray with input: {}", Arrays.toString(input));
            int[] result = BubbleSort.bubbleSort(input);
            logger.info("testUnsortedArray result: {}", Arrays.toString(result));
            assertArrayEquals(expected, result, "Expected sorted array");
        }

        @Test
        @DisplayName("Test bubble sort with already sorted array")
        @Description("Verify sorting of an already sorted array [1, 2, 3, 4, 5]")
        public void testSortedArray() {
            int[] input = {1, 2, 3, 4, 5};
            int[] expected = {1, 2, 3, 4, 5};
            logger.info("Starting testSortedArray with input: {}", Arrays.toString(input));
            int[] result = BubbleSort.bubbleSort(input);
            logger.info("testSortedArray result: {}", Arrays.toString(result));
            assertArrayEquals(expected, result, "Expected same sorted array");
        }

        @Test
        @DisplayName("Test bubble sort with empty array")
        @Description("Verify sorting of an empty array")
        public void testEmptyArray() {
            int[] input = {};
            int[] expected = {};
            logger.info("Starting testEmptyArray with input: {}", Arrays.toString(input));
            int[] result = BubbleSort.bubbleSort(input);
            logger.info("testEmptyArray result: {}", Arrays.toString(result));
            assertArrayEquals(expected, result, "Expected empty array");
        }

        @Test
        @DisplayName("Test bubble sort with single-element array")
        @Description("Verify sorting of a single-element array [42]")
        public void testSingleElementArray() {
            int[] input = {42};
            int[] expected = {42};
            logger.info("Starting testSingleElementArray with input: {}", Arrays.toString(input));
            int[] result = BubbleSort.bubbleSort(input);
            logger.info("testSingleElementArray result: {}", Arrays.toString(result));
            assertArrayEquals(expected, result, "Expected single-element array");
        }

        @Test
        @DisplayName("Test bubble sort with null array")
        @Description("Verify null input throws IllegalArgumentException")
        public void testNullArray() {
            logger.info("Starting testNullArray with null input");
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                BubbleSort.bubbleSort(null);
            }, "Expected IllegalArgumentException for null input");
            logger.info("testNullArray exception: {}", exception.getMessage());
            assertEquals("Array must not be null", exception.getMessage());
        }
}
