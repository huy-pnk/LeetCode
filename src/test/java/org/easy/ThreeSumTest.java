package org.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeSumTest {

    private final ThreeSum threeSum = new ThreeSum();

    @Test
    void shouldReturnTrueWhenThreeNumbersSumToTarget() {
        assertTrue(threeSum.findThreeSum(new int[]{3, 7, 1, 2, 8, 4, 5}, 11));
    }

    @Test
    void shouldReturnFalseWhenNoThreeNumbersSumToTarget() {
        assertFalse(threeSum.findThreeSum(new int[]{3, 7, 1, 2, 8, 4, 5}, 99));
    }

    @Test
    void shouldReturnFalseForArraySmallerThanThree() {
        assertFalse(threeSum.findThreeSum(new int[]{1, 2}, 3));
    }

    @Test
    void shouldReturnFalseForNullArray() {
        assertFalse(threeSum.findThreeSum(null, 5));
    }
}
