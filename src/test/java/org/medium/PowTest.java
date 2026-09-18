package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowTest {
    Pow pow = new Pow();

    @Test
    void test1() {
        Assertions.assertEquals(1024, pow.myPow(2.0, 10));
    }

    @Test
    void test2() {
        Assertions.assertEquals(0.25, pow.myPow(2.0, -2));
    }
}
