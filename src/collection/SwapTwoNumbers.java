package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {
                {2, 5, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        System.out.println(arrayManipulation(n, queries));


    }

    public static long arrayManipulation(int n, int[][] queries) {
        long[] prefixSumArray = new long[n + 2]; // Initialize a prefix sum array of size n+2

        // Iterate through each query and update prefix sum array accordingly
        for (int[] query : queries) {
            int leftIndex = query[0]; // 1-based indexing
            int rightIndex = query[1];
            int value = query[2];

            prefixSumArray[leftIndex] += value; // Add value to the start index
            prefixSumArray[rightIndex + 1] -= value; // Subtract value from the next index after end index
        }

        // Calculate the actual array by taking cumulative sum of prefix sum array
        long max = Long.MIN_VALUE;
        long currentSum = 0;
        for (int i = 1; i <= n; i++) {
            currentSum += prefixSumArray[i];
            max = Math.max(max, currentSum);
        }

        return max;// Print the maximum value


    }

}
