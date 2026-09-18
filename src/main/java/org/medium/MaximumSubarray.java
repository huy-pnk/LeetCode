package org.medium;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println();
        return maxSum;
    }
}
