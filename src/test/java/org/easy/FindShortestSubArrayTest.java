package org.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindShortestSubArrayTest {
    FindShortestSubArray findShortestSubArray = new FindShortestSubArray();

    @Test
    public void test1() {
        int[] nums = {1,2,2,3,1};
        assertEquals(2, findShortestSubArray.findShortestSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1,2,2,3,1,4,2};
        assertEquals(6, findShortestSubArray.findShortestSubArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1};
        assertEquals(1, findShortestSubArray.findShortestSubArray(nums));
    }

    @Test
    public void test4() {
        int[] nums = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        assertEquals(7, findShortestSubArray.findShortestSubArray(nums));
    }

    @Test
    public void test5() {
        int[] nums = {6,5,5};
        assertEquals(2, findShortestSubArray.findShortestSubArray(nums));
    }

    @Test
    public void test6() {
        int[] nums = {1,3,2,2,3,1};
        assertEquals(2, findShortestSubArray.findShortestSubArray(nums));
    }



}
