package org.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

    private final MergeSortedArray solution = new MergeSortedArray();

    @Test
    void shouldMergeTwoSortedArrays() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void shouldHandleEmptyNums2() {
        int[] nums1 = {1};
        solution.merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void shouldHandleEmptyNums1() {
        int[] nums1 = {0};
        solution.merge(nums1, 0, new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void shouldHandleArraysWithZeros() {
        int[] nums1 = {0, 0, 0};
        solution.merge(nums1, 0, new int[]{0, 0, 0}, 3);
        assertArrayEquals(new int[]{0, 0, 0}, nums1);
    }
}
