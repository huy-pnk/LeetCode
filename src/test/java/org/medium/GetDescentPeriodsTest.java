package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetDescentPeriodsTest {
    private final GetDescentPeriods getDescentPeriods = new GetDescentPeriods();

    @Test
    public void test1() {
        int[] prices = {3,2,1,4};
        Assertions.assertEquals(7, getDescentPeriods.getDescentPeriods(prices));
    }

    @Test
    public void test2() {
        int[] prices = {8,6,7,7};
        Assertions.assertEquals(4, getDescentPeriods.getDescentPeriods(prices));
    }

    @Test
    public void test3() {
        int[] prices = {1};
        Assertions.assertEquals(1, getDescentPeriods.getDescentPeriods(prices));
    }

    @Test
    public void test4() {
        int[] prices = {12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7};
        Assertions.assertEquals(68, getDescentPeriods.getDescentPeriods(prices));
    }
}
