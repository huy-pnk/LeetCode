package org.medium;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(i>0 && i+1<nums.length && nums[i] == nums[i+1]) {
                int c = 1;
                for(int j=i+1;j<nums.length;j++)
                    if(nums[j] == nums[i]) c++;

                if(c <= count.getOrDefault(nums[i], 0)) count.put(nums[i], c);
            }
            else if(count.getOrDefault(nums[i], 0) < k) {
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> pair : count.entrySet()) {
            result += pair.getValue();
        }
        return result;
    }
}
