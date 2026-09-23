package org.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">...</a>
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        if(nums[0] > x && nums[nums.length-1] > x) return -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sumSubArray = sum - x;
        if(sumSubArray == 0) return nums.length;
        int length = longestSubarray(nums, sumSubArray);
        if(length == 0) return -1;
        else return nums.length-length;
    }

    private int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];

            if (prefSum == k)
                res = i + 1;
            else if (mp.containsKey(prefSum - k))
                res = Math.max(res, i - mp.get(prefSum - k));
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }
        return res;
    }
}
