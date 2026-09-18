package org.medium;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/?envType=problem-list-v2&envId=two-pointers
 */
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        int i=0,j=nums.length-1;
        while (i<j) {
            if(nums[i] == sortedNums[i]) i++;
            if(nums[j] == sortedNums[j]) j--;

            if(nums[i] != sortedNums[i] && nums[j] != sortedNums[j]) break;
        }

        return i<j?j-i+1:0;
    }

}
