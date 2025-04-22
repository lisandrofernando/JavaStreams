package com.practice.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;


public class BubbleSortChallenge {
    private static final Logger logger = LogManager.getLogger(BubbleSortChallenge.class);

    /**
     * Sorts an array using bubble sort algorithm with Java Streams.
     * @param array Input array to sort
     * @return Sorted array
     * @throws IllegalArgumentException if array is null
     */
    public static int[] bubbleSort(int[] array) {
        logger.info("Starting bubble sort on array: {}", Arrays.toString(array));

        if (array == null) {
            logger.error("Input array is null");
            throw new IllegalArgumentException("Array must not be null");
        }

        if (array.length <= 1) {
            logger.debug("Array length <= 1, returning as is: {}", Arrays.toString(array));
            return Arrays.copyOf(array, array.length);
        }

        // Perform bubble sort passes
        int[] result = Arrays.copyOf(array, array.length);
        int n = result.length;

        // Simulate passes (n passes for worst case)
        IntStream.range(0, n).forEach(pass -> {
            logger.debug("Pass {}", pass);
            // Compare and swap adjacent elements using Stream
            int[] temp = IntStream.range(0, n - 1 - pass)
                    .mapToObj(i -> {
                        if (result[i] > result[i + 1]) {
                            // Swap
                            int swap = result[i];
                            result[i] = result[i + 1];
                            result[i + 1] = swap;
                            logger.trace("Swapped {} and {} at indices {} and {}", result[i], result[i + 1], i, i + 1);
                        }
                        return result[i];
                    })
                    .mapToInt(Integer::intValue)
                    .toArray();

            // Update result for indices processed
            System.arraycopy(temp, 0, result, 0, temp.length);
        });

        logger.info("Sorted array: {}", Arrays.toString(result));
        return result;
    }
}
