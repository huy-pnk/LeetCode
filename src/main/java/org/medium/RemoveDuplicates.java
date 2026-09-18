package org.medium;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int swap=0;
        int current = nums[0];
        int i=1;
        int temp;
        while(i < nums.length) {
            if(nums[i]==current) {
                count++;
                if(swap>0) {
                    nums[i] = nums[i-swap];
                }

            }
            else if(nums[i] < current) continue;
            else
            {
                current = nums[i];
                count=1;
                if(swap>0) {
                    nums[i] = nums[i-swap];
                }

            }

            if(count>2) swap++;
            i++;
        }

        return nums.length-swap;
    }
}
