package org.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLongestSubarrayWithAtMostKFrequencyTest {
    LengthOfLongestSubarrayWithAtMostKFrequency lengthOfLongestSubarrayWithAtMostKFrequency = new LengthOfLongestSubarrayWithAtMostKFrequency();

    @Test
    public void test1() {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        assertEquals(6, lengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1,2,1,2,1,2,1,2};
        int k = 1;
        assertEquals(2, lengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k));
    }

    @Test
    public void test3() {
        int[] nums = {5,5,5,5,5,5,5};
        int k = 4;
        assertEquals(4, lengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k));
    }

    @Test
    public void test4() {
        int[] nums = {1,4,1};
        int k = 2;
        assertEquals(3, lengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k));
    }
}
