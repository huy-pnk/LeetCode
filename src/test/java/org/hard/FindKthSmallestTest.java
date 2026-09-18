package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindKthSmallestTest {
    private final FindKthSmallest findKthSmallest = new FindKthSmallest();

    @Test
    public void test1() {
        int[] coins = {3,6,9};
        int k = 3;
        Assertions.assertEquals(9, findKthSmallest.findKthSmallest(coins, k));
    }

    @Test
    public void test2() {
        int[] coins = {5,2};
        int k = 7;
        Assertions.assertEquals(12, findKthSmallest.findKthSmallest(coins, k));
    }

    @Test
    public void test3() {
        int[] coins = {6,5};
        int k = 1000000000;
        Assertions.assertEquals(12, findKthSmallest.findKthSmallest(coins, k));
    }

}
