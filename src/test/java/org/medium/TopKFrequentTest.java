package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TopKFrequentTest {
    TopKFrequent topKFrequent = new TopKFrequent();

    @Test
    public void test1() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expectedResult = {1,2};
        int[] result = topKFrequent.topKFrequent(nums,k);
        Arrays.sort(expectedResult);
        Arrays.sort(result);
        Assertions.assertArrayEquals(expectedResult,  result);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 1;
        int[] expectedResult = {1};
        int[] result = topKFrequent.topKFrequent(nums,k);
        Arrays.sort(expectedResult);
        Arrays.sort(result);
        Assertions.assertArrayEquals(expectedResult,  result);
    }

    @Test
    public void test3() {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] expectedResult = {1,2};
        int[] result = topKFrequent.topKFrequent(nums,k);
        Arrays.sort(expectedResult);
        Arrays.sort(result);
        Assertions.assertArrayEquals(expectedResult,  result);
    }
}
