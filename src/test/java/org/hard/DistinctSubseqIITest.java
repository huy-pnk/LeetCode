package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistinctSubseqIITest {
    private final DistinctSubseqII distinctSubseqII = new DistinctSubseqII();

    @Test
    public void test1() {
        String s = "abc";
        Assertions.assertEquals(7 , distinctSubseqII.distinctSubseqII(s));
    }

    @Test
    public void test2() {
        String s = "aba";
        Assertions.assertEquals(6 , distinctSubseqII.distinctSubseqII(s));
    }

    @Test
    public void test3() {
        String s = "aaa";
        Assertions.assertEquals(3 , distinctSubseqII.distinctSubseqII(s));
    }
}
