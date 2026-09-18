package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindUnsortedSubarrayTest {
    private final FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();

    @Test
    public void test1() {
        int[] nums = {2,6,4,8,10,9,15};
        Assertions.assertEquals(5, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1,2,3,4};
        Assertions.assertEquals(0, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1};
        Assertions.assertEquals(0, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

    @Test
    public void test4() {
        int[] nums = {2,1};
        Assertions.assertEquals(2, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

    @Test
    public void test5() {
        int[] nums = {1,3,2,4,5};
        Assertions.assertEquals(2, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

    @Test
    public void test6() {
        int[] nums = {1,2};
        Assertions.assertEquals(0, findUnsortedSubarray.findUnsortedSubarray(nums));
    }

}
