package org.medium;

import java.util.ArrayDeque;

/**
 * 3904. Smallest Stable Index II
 * https://leetcode.com/problems/smallest-stable-index-ii/
 */
public class FirstStableIndex {
    public int firstStableIndex(int[] nums, int k) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int minIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if(minIdx == -1)
                minIdx = findMin(nums, i);
            else if(i > minIdx && nums[i] != nums[minIdx])
                minIdx = findMin(nums, i);

            if((max - nums[minIdx]) <= k) return i;
        }
        return result;
    }

    public int findMin(int[] nums, int index) {
        int min = Integer.MAX_VALUE;
        int minIdx = index;
        for (int i = index; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
                minIdx = i;
            }
        }
        return minIdx;
    }



//    public int firstStableIndex(int[] nums, int k) {
//        int result = -1;
//        for (int i = 0; i < nums.length; i++) {
//            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//            for (int j = 0; j <= i; j++)
//                max = Math.max(nums[j], max);
//            for (int j = i; j < nums.length; j++)
//                min = Math.min(nums[j], min);
//            if((max - min) <= k) return i;
//        }
//        return result;
//    }
}
