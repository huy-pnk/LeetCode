package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmallestDivisibleDigitProductIITest {
    private SmallestDivisibleDigitProductII smallestDivisibleDigitProductII = new SmallestDivisibleDigitProductII();

    @Test
    public void test1() {
        String num = "1234";
        long t = 256;
        Assertions.assertEquals("1488", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test2() {
        String num = "11111";
        long t = 26;
        Assertions.assertEquals("-1", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test3() {
        String num = "10";
        long t = 320;
        Assertions.assertEquals("588", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test4() {
        String num = "12";
        long t = 1968750;
        Assertions.assertEquals("255555579", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test6() {
        String num = "12";
        long t = 22020096000L;
        Assertions.assertEquals("2555678888888", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test5() {
        String num = "17";
        long t = 252047376;
        Assertions.assertEquals("2777789999", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test7() {
        String num = "30";
        long t = 9;
        Assertions.assertEquals("33", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test8() {
        String num = "90";
        long t = 53888;
        Assertions.assertEquals("-1", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test9() {
        String num = "11111111111111104254";
        long t = 97977600000000L;
        Assertions.assertEquals("-1", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test10() {
        String num = "19";
        long t = 2;
        Assertions.assertEquals("21", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

    @Test
    public void test11() {
        String num = "26";
        long t = 9;
        Assertions.assertEquals("91", smallestDivisibleDigitProductII.smallestNumber(num, t));
    }

}
