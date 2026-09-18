package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxOperationsTest {
    private final MaxOperations maxOperations = new MaxOperations();

    @Test
    public void test1() {
        int[] nums = {1,2,3,4};
        int k = 5;
        Assertions.assertEquals(2, maxOperations.maxOperations(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        Assertions.assertEquals(1, maxOperations.maxOperations(nums, k));
    }
}
