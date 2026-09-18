package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstStableIndexTest {
    private final FirstStableIndex firstStableIndex = new FirstStableIndex();

    @Test
    public void test1() {
        int[] nums = new int[]{5,0,1,4};
        int k = 3;
        Assertions.assertEquals(3, firstStableIndex.firstStableIndex(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3,2,1};
        int k = 1;
        Assertions.assertEquals(-1, firstStableIndex.firstStableIndex(nums, k));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{0};
        int k = 0;
        Assertions.assertEquals(0, firstStableIndex.firstStableIndex(nums, k));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1,7};
        int k = 1;
        Assertions.assertEquals(0, firstStableIndex.firstStableIndex(nums, k));
    }

    @Test
    public void test5() {
        int[] nums = new int[]{10,3,10,3};
        int k = 4;
        Assertions.assertEquals(-1, firstStableIndex.firstStableIndex(nums, k));
    }

    @Test
    public void test6() {
        int[] nums = new int[]{10,0,7,2,10,2,9};
        int k = 0;
        Assertions.assertEquals(-1, firstStableIndex.firstStableIndex(nums, k));
    }
}
