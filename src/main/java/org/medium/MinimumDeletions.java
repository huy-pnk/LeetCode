package org.medium;

/**
 * 2091. Removing Minimum and Maximum From Array
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */
public class MinimumDeletions {
    public int minimumDeletions(int[] nums) {
        int result = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {min = nums[i]; minIdx = i;}
            if(nums[i] > max) {max = nums[i]; maxIdx = i;}
        }
        result = Math.min(Math.max(minIdx, maxIdx) + 1, result);
        result = Math.min(nums.length-Math.min(minIdx, maxIdx), result);
        result = Math.min(result, (Math.min(minIdx, maxIdx) + 1) + nums.length - Math.max(minIdx, maxIdx));
        return result;
    }
}
