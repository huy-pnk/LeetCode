package org.hard;

import java.util.Arrays;
import java.util.stream.Stream;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Step 1: Initialize both arrays with 1 (every child gets at least 1 candy)
        int[] left  = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Step 2: Left → Right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Step 3: Right → Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Step 4: Sum up the max of both arrays at each position
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.max(left[i], right[i]);
        }

        return total;
    }
}
