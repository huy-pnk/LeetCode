package org.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1855. Maximum Distance Between a Pair of Values
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/?envType=problem-list-v2&envId=two-pointers
 */
public class MaxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance=0;

        for (int i = nums2.length-1; i >=0; i--) {
            int index = firstIndex(nums1, nums2[i]);
            if(index != -1 && i>=index && nums2[i] >= nums1[index] && maxDistance < i - index) maxDistance = i - index;
            if(maxDistance > 0) return maxDistance;
        }
        return maxDistance;
    }

    public int firstIndex(int[] arr, int number) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= number) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo >= arr.length ? -1 : lo;
    }

}
