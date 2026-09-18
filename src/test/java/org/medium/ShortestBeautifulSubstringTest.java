package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestBeautifulSubstringTest {
    private final ShortestBeautifulSubstring shortestBeautifulSubstring = new ShortestBeautifulSubstring();

    @Test
    public void test1() {
        String s = "100011001";
        int k = 3;
        Assertions.assertEquals("11001", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test2() {
        String s = "1011";
        int k = 2;
        Assertions.assertEquals("11", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test3() {
        String s = "000";
        int k = 1;
        Assertions.assertEquals("", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test4() {
        String s = "10100010";
        int k = 5;
        Assertions.assertEquals("", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test5() {
        String s = "001";
        int k = 1;
        Assertions.assertEquals("1", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test6() {
        String s = "10001";
        int k = 3;
        Assertions.assertEquals("", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test7() {
        String s = "001110101101101111";
        int k = 10;
        Assertions.assertEquals("10101101101111", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test8() {
        String s = "001";
        int k = 1;
        Assertions.assertEquals("1", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test9() {
        String s = "11";
        int k = 2;
        Assertions.assertEquals("11", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void test10() {
        String s = "110101000010110101";
        int k = 3;
        Assertions.assertEquals("1011", shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }




}
