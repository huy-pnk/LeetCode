package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultArrayTest {
    private final ResultArray resultArray = new ResultArray();

    @Test
    public void test1() {
        int[] nums = {2,1,3};
        Assertions.assertArrayEquals(new int[]{2,3,1}, resultArray.resultArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {5,4,3,8};
        Assertions.assertArrayEquals(new int[]{5,3,4,8}, resultArray.resultArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1,2,4};
        Assertions.assertArrayEquals(new int[]{1,2,4}, resultArray.resultArray(nums));
    }


}
