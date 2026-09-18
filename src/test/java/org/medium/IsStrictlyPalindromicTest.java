package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsStrictlyPalindromicTest {
    private final IsStrictlyPalindromic isStrictlyPalindromic = new IsStrictlyPalindromic();
    @Test
    public void test1() {
        int n=9;
        Assertions.assertFalse(isStrictlyPalindromic.isStrictlyPalindromic(n));
    }

    @Test
    public void test2() {
        int n=4;
        Assertions.assertFalse(isStrictlyPalindromic.isStrictlyPalindromic(n));
    }
}
