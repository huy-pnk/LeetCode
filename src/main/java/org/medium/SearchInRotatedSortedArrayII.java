package org.medium;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(nums[low] == target || nums[mid] == target || nums[high] == target) return true;
            else if(nums[low] < target && target < nums[mid]) {
                high = mid;
                low++;
            } else if(nums[mid] < target && target < nums[high]) {
                low = mid;
                high--;
            } else {
                low++;
                high--;
            }
        }
        return false;
    }
}
