package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubsequenceTest {
    LongestSubsequence longestSubsequence = new LongestSubsequence();

    @Test
    public void test1() {
        int[] nums = {1,2,3};
        Assertions.assertEquals(2, longestSubsequence.longestSubsequence(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2,3,4};
        Assertions.assertEquals(3, longestSubsequence.longestSubsequence(nums));
    }

    @Test
    public void test3() {
        int[] nums = {0,0,7,0,0,0,7,0,0};
        Assertions.assertEquals(8, longestSubsequence.longestSubsequence(nums));
    }

    @Test
    public void test4() {
        int[] nums = {6,0};
        Assertions.assertEquals(2, longestSubsequence.longestSubsequence(nums));
    }

    @Test
    public void test5() {
        int[] nums = {1000000000,1000000000,1000000000,1000000000,294967296};
        Assertions.assertEquals(5, longestSubsequence.longestSubsequence(nums));
    }

}
