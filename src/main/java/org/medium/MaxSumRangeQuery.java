package org.medium;

import java.math.BigInteger;
import java.util.*;

/**
 * 1589. Maximum Sum Obtained of Any Permutation
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 */
public class MaxSumRangeQuery {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] frequently = new int[n];
        final int MOD = 1_000_000_007;

        // Difference array để tính frequency O(1) mỗi request
        int[] diff = new int[n + 1];
        for (int[] request : requests) {
            diff[request[0]]++;
            diff[request[request.length - 1] + 1]--;
        }
        int running = 0;
        for (int i = 0; i < n; i++) {
            running += diff[i];
            frequently[i] = running;
        }

        Arrays.sort(nums);
        Arrays.sort(frequently);

        long result = 0L;
        for (int i = n - 1; i >= 0 && frequently[i] > 0; i--) {
            // ép kiểu long TRƯỚC khi nhân để tránh overflow int*int
            result += (long) nums[i] * (long) frequently[i];
            result %= MOD; // mod ngay trong vòng lặp, tránh result phình quá lớn
        }

        return (int) result;
    }
}
