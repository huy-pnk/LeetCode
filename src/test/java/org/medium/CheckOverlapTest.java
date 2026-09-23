package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckOverlapTest {
    private final CheckOverlap checkOverlap = new CheckOverlap();


    @Test
    void test1() {
        Assertions.assertTrue(checkOverlap.checkOverlap(1, 0, 0, 1, -1, 3, 1));
    }

    @Test
    void test2() {
        Assertions.assertFalse(checkOverlap.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }

    @Test
    void test3() {
        Assertions.assertTrue(checkOverlap.checkOverlap(1, 0, 0, -1, 0, 0, 1));
    }
}
