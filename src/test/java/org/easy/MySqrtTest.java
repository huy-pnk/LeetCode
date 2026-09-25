package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MySqrtTest {
    private final MySqrt mySqrt = new MySqrt();

    @Test
    public void test1() {
        Assertions.assertEquals(2, mySqrt.mySqrt(8));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, mySqrt.mySqrt(2));
    }
}
