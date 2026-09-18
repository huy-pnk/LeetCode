package org.medium;

import java.util.Arrays;

/**
 * 1712. Ways to Split Array Into Three Subarrays
 * https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/?envType=problem-list-v2&envId=two-pointers
 */
public class WaysToSplit {

    public int waysToSplit(int[] nums) {
        final int MOD = 1_000_000_007;
        if(nums.length < 3) return 0;
        if(nums.length == 3 && ((nums[0] > nums[1]) || (nums[1] > nums[2]))) return 0;
        if(nums.length == 3 && nums[0] <= nums[1] && nums[1] == nums[2]) return 1;
        long sum=0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            sum %= MOD;
        }

        int count=0;
        return count;
    }

    int binarySearch(int a[], int l, int r, int x){

        while (l <= r){

            int m = (l + r) / 2;

            // Index of Element Returned
            if (a[m] == x) {
                return m;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                // so we decrease our r pointer to mid - 1
            }
            else if (a[m] > x) {
                r = m - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our l pointer to mid + 1
            }
            else {
                l = m + 1;
            }
        }

        // No Element Found
        return -1;
    }

//    public int waysToSplit(int[] nums) {
//        final int MOD = 1_000_000_007;
//        if(nums.length < 3) return 0;
//        if(nums.length == 3 && ((nums[0] > nums[1]) || (nums[1] > nums[2]))) return 0;
//        if(nums.length == 3 && nums[0] <= nums[1] && nums[1] == nums[2]) return 1;
//        long sum=0;
//        for(int i=0;i<nums.length;i++) {
//            sum += nums[i];
//            sum %= MOD;
//        }
//        int count=0;
//        long sumLeft=0;
//        for(int i=0;i<nums.length-2 && sumLeft < sum/3;i++) {
//            long sumMid=0, sumRight=0;
//            sumLeft += nums[i];
//            sumLeft %= MOD;
//            sumMid = 0;
//            for(int j=i+1;j<nums.length-1 && (sum-sumLeft-sumMid) >= sumMid;j++) {
//                sumMid+=nums[j];
//                sumMid %= MOD;
//                sumRight = sum-sumLeft-sumMid;
//                sumRight %= MOD;
//                if(sumLeft <= sumMid && sumRight >= sumMid) count++;
//            }
//        }
//        return count;
//    }




}
