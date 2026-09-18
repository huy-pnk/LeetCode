package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PivotArrayTest {
    private final PivotArray pivotArray = new PivotArray();

    @Test
    public void test1() {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;

        Assertions.assertArrayEquals(new int[] {9,5,3,10,10,12,14}, pivotArray.pivotArray(nums, pivot));
    }

    @Test
    public void test2() {
        int[] nums = {-3,4,3,2};
        int pivot = 2;

        Assertions.assertArrayEquals(new int[] {-3,2,4,3}, pivotArray.pivotArray(nums, pivot));
    }
}
