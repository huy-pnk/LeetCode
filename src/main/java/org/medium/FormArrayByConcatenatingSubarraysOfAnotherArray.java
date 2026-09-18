package org.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1764. Form Array by Concatenating Subarrays of Another Array
 * https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/description/?envType=problem-list-v2&envId=two-pointers
 */
public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    public boolean canChoose(int[][] groups, int[] nums) {
        int finalCount = 0;
        int i=0;
        int j=0;
        int count =0;
        int lastIndex = 0;
        for (int k = 0; k < nums.length; k++) {
            if(nums[k] == groups[i][j]) {
                count++;
                j++;
            }
            else if(nums[k] != groups[i][j] && count < groups[i].length) {
                count = 0;
                j=0;
            }
            if(nums[k] == groups[i][groups[i].length-1]) {
                // run back to reconfirm
                int index = k;
                for (int l = groups[i].length-1; l >= 0; l--) {
                    if(l == 0 && groups[i][l] == nums[index] && lastIndex != index) {
                        count = 0;
                        finalCount++;
                        i++;
                        j=0;
                        if(finalCount == groups.length) return true;
                    }
                    if(groups[i][l] == nums[index]) {
                        index--;
                    }
                    else if (groups[i][l] != nums[index]) break;

                }
            }
            if(count == groups[i].length) {
                lastIndex = k;
                count = 0;
                finalCount++;
                i++;
                j=0;
                if(finalCount == groups.length) return true;
            }
        }


        if(finalCount == groups.length) return true;
        else return false;
    }
}
