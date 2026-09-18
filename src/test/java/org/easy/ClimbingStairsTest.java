package org.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClimbingStairsTest {
    private final ClimbingStairs climbingStairs = new ClimbingStairs();
    @Test
    void test1() {
        assertEquals(2, climbingStairs.climbStairs(2));
    }

    @Test
    void test2() {
        assertEquals(3, climbingStairs.climbStairs(3));
    }
}
