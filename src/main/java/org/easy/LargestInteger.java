package org.easy;

import org.medium.TopKFrequent;

import java.util.*;

/**
 * 3471. Find the Largest Almost Missing Integer
 * https://leetcode.com/problems/find-the-largest-almost-missing-integer/
 */
public class LargestInteger {
    public int largestInteger(int[] nums, int k) {
        int max = -1;

        // case k = 1
        if(k == nums.length) {
            for (int i = 0; i < nums.length; i++)
                if(max < nums[i]) max = nums[i];
            return max;
        }
        else if(k == 1) {
            Arrays.sort(nums);
            Map<Integer, Integer> map =new HashMap<>();
            int count = 0;
            for (int i = nums.length-1; i >=0; i--) {
                if(!map.containsKey(nums[i]))  {
                    map.put(nums[i], 1);
                    if(count == 1 && max != nums[i])
                        return max;
                    max = nums[i];
                    count++;
                }
                else if(map.containsKey(nums[i])) {
                    max = -1;
                    count = 0;
                }
            }
            return max;
        }
        else {
            if(nums[0] == nums[nums.length-1]) return -1;
            int first = 0;
            int last = 0;
            for (int i = 1; i < nums.length-1; i++) {
                if(nums[i] == nums[0]) first++;
                if(nums[i] == nums[nums.length-1]) last++;
                if(last > 0 && first > 0) break;
            }

            if(first == 0 && last == 0) {
                return Math.max(nums[0], nums[nums.length-1]);
            } else if(first == 0 && last > 0) return nums[0];
            else if(first > 0 && last == 0) return nums[nums.length-1];
            else return -1;
        }
    }
}
