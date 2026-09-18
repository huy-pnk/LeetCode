package org.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SmallestMissingIntegerGreaterThanSequentialPrefixSumTest {
    SmallestMissingIntegerGreaterThanSequentialPrefixSum smallestMissingIntegerGreaterThanSequentialPrefixSum = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();

    @Test
    public void test1() {
        int[] nums = {1,2,3,2,5};
        assertEquals(6, smallestMissingIntegerGreaterThanSequentialPrefixSum.missingInteger(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3,4,5,1,12,14,13};
        assertEquals(15, smallestMissingIntegerGreaterThanSequentialPrefixSum.missingInteger(nums));
    }

    @Test
    public void test3() {
        int[] nums = {29,30,31,32,33,34,35,36,37};
        assertEquals(297, smallestMissingIntegerGreaterThanSequentialPrefixSum.missingInteger(nums));
    }

    @Test
    public void test4() {
        int[] nums = {4,5,6,7,8,8,9,4,3,2,7};
        assertEquals(30, smallestMissingIntegerGreaterThanSequentialPrefixSum.missingInteger(nums));
    }

}
