package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckDivisibilityTest {
    private final CheckDivisibility checkDivisibility = new CheckDivisibility();

    @Test
    public void test1() {
        int n = 99;
        Assertions.assertTrue(checkDivisibility.checkDivisibility(n));
    }

    @Test
    public void test2() {
        int n = 23;
        Assertions.assertFalse(checkDivisibility.checkDivisibility(n));
    }
}
