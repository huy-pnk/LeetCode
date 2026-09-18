package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountCommasTest {
    private final CountCommas countComma = new CountCommas();

    @Test
    public void test1() {
        long n = 1002;
        Assertions.assertEquals(3, countComma.countCommas(n));
    }

    @Test
    public void test2() {
        long n = 1004590;
        Assertions.assertEquals(1008182, countComma.countCommas(n));
    }


}
