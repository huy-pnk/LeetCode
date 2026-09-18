package org.medium;

public class LongestSubsequence {
    public int longestSubsequence(int[] nums) {
        int count = nums.length;
        int result = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != 0)
                result = result ^ nums[i];
            sum += nums[i];
        }
        if(sum == 0) return 0;
        if(result == 0) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    result = result ^ nums[i];
                    count--;
                }
                if(result != 0) return count;
            }
        }
        return count;
    }
}
