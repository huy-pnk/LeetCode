package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoneGameIXTest {
    StoneGameIX stoneGameIX = new StoneGameIX();

    @Test
    public void test1() {
        int[] stones = {2,1};
        Assertions.assertTrue(stoneGameIX.stoneGameIX(stones));
    }

    @Test
    public void test2() {
        int[] stones = {2};
        Assertions.assertFalse(stoneGameIX.stoneGameIX(stones));
    }

    @Test
    public void test3() {
        int[] stones = {5,1,2,4,3};
        Assertions.assertFalse(stoneGameIX.stoneGameIX(stones));
    }

    @Test
    public void test4() {
        int[] stones = {1,1,7,10,8,17,10,20,2,10};
        Assertions.assertTrue(stoneGameIX.stoneGameIX(stones));
    }


}
