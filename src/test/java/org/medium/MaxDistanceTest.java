package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxDistanceTest {
    private final MaxDistance maxDistance = new MaxDistance();

    @Test
    public void test1() {
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};

        Assertions.assertEquals(2, maxDistance.maxDistance(nums1, nums2));
    }

    @Test
    public void test2() {
        int[] nums1 = {2,2,2};
        int[] nums2 = {10,10,1};

        Assertions.assertEquals(1, maxDistance.maxDistance(nums1, nums2));
    }

    @Test
    public void test3() {
        int[] nums1 = {30,29,19,5};
        int[] nums2 = {25,25,25,25,25};

        Assertions.assertEquals(2, maxDistance.maxDistance(nums1, nums2));
    }


    @Test
    public void test4() {
        int[] nums1 = {9952};
        int[] nums2 = {9556,9362,9217,9056,8782,8625};

        Assertions.assertEquals(0, maxDistance.maxDistance(nums1, nums2));
    }

}
