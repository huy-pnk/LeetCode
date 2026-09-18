package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LexicographicallySmallestArrayTest {
    private final LexicographicallySmallestArray lexicographicallySmallestArray = new LexicographicallySmallestArray();

    @Test
    public void test1() {
        int[] nums = {1,5,3,9,8};
        int limit = 2;

        int[] result = {1,3,5,8,9};
        Assertions.assertArrayEquals(result, lexicographicallySmallestArray.lexicographicallySmallestArray(nums, limit));
    }


    @Test
    public void test2() {
        int[] nums = {1,60,34,84,62,56,39,76,49,38};
        int limit = 4;

        int[] result = {1,56,34,84,60,62,38,76,49,39};
        Assertions.assertArrayEquals(result, lexicographicallySmallestArray.lexicographicallySmallestArray(nums, limit));
    }

}
