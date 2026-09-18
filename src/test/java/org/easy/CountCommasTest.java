package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountCommasTest {
    private final CountCommas countCommas = new CountCommas();

    @Test
    public void test1() {
        int n = 1002;
        Assertions.assertEquals(3, countCommas.countCommas(n));
    }

    @Test
    public void test2() {
        int n = 998;
        Assertions.assertEquals(0, countCommas.countCommas(n));
    }
}
