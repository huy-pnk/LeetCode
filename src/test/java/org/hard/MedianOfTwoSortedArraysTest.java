package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @Test
    void test1() {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Assertions.assertEquals(2, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test2() {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        Assertions.assertEquals(2.5, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test3() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        Assertions.assertEquals(1, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test4() {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{6,7,8,9,10,11,12,13,14,15,16,17};
        Assertions.assertEquals(9.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
