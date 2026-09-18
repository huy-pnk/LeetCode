package org.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];   // copy nums2 into the buffer slots of nums1
        }
        Arrays.sort(nums1);            // sort in-place — modifies the original array
    }
}
