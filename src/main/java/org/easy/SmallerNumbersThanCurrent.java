package org.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  1365. How Many Numbers Are Smaller Than the Current Number
 *  https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countArray = new int[101];
        for(int i=0;i<nums.length;i++) {
            countArray[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for(int j=0;j<nums[i];j++) count+= countArray[j];
            nums[i] = count;
        }
        return nums;
    }
}
