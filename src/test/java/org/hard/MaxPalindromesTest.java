package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxPalindromesTest {
    private final MaxPalindromes maxPalindromes = new MaxPalindromes();

    @Test
    public void test1() {
        String s = "abaccdbbd";
        int k = 3;
        Assertions.assertEquals(2, maxPalindromes.maxPalindromes(s, k));
    }

    @Test
    public void test2() {
        String s = "adbcda";
        int k = 2;
        Assertions.assertEquals(0, maxPalindromes.maxPalindromes(s, k));
    }

    @Test
    public void test3() {
        String s = "kwnwkekokedadq";
        int k = 5;
        Assertions.assertEquals(2, maxPalindromes.maxPalindromes(s, k));
    }

    @Test
    public void test4() {
        String s = "fttfjofpnpfydwdwdnns";
        int k = 2;
        Assertions.assertEquals(4, maxPalindromes.maxPalindromes(s, k));
    }

    @Test
    public void test5() {
        String s = "iqqibcecvrbxxj";
        int k = 1;
        Assertions.assertEquals(14, maxPalindromes.maxPalindromes(s, k));
    }

    @Test
    public void test6() {
        String s = "sjbxiufnaanqkwsqswkqrcznzcddhtuhtthuttjfuufjtcfywgecegwyhhnnhtozczirynhhnyrire";
        int k = 3;
        Assertions.assertEquals(10, maxPalindromes.maxPalindromes(s, k));
    }
}
