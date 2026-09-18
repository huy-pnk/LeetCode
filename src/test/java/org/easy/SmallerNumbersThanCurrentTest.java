package org.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmallerNumbersThanCurrentTest {
    SmallerNumbersThanCurrent smallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
    @Test
    public void test1() {
        int[] arr = {8,1,2,2,3};
        int[] result = {4,0,1,1,3};
        assertArrayEquals(result, smallerNumbersThanCurrent.smallerNumbersThanCurrent(arr));
    }

    @Test
    public void test2() {
        int[] arr = {6,5,4,8};
        int[] result = {2,1,0,3};
        assertArrayEquals(result, smallerNumbersThanCurrent.smallerNumbersThanCurrent(arr));
    }

    @Test
    public void test3() {
        int[] arr = {7,7,7,7};
        int[] result = {0,0,0,0};
        assertArrayEquals(result, smallerNumbersThanCurrent.smallerNumbersThanCurrent(arr));
    }
}
