package org.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3718. Smallest Missing Multiple of K
 * https://leetcode.com/problems/smallest-missing-multiple-of-k/
 */
public class MissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % k == 0) set.add(nums[i]);
        }
        int index=1;
        int temp = k*index;
        while(set.contains(temp)) {
            index++;
            temp = k*index;
        }
        return temp;
    }
}
