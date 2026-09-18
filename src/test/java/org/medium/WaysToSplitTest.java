package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaysToSplitTest {
    private final WaysToSplit waysToSplit = new WaysToSplit();

    @Test
    public void test1() {
        int[] nums = {1,2,2,2,5,0};
        Assertions.assertEquals(3, waysToSplit.waysToSplit(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0,3,3};
        Assertions.assertEquals(1, waysToSplit.waysToSplit(nums));
    }

    @Test
    public void test3() {
        int[] nums = {5,10,1,10,4};
        Assertions.assertEquals(2, waysToSplit.waysToSplit(nums));
    }




}
