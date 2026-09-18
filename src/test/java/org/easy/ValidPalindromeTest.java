package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
    private ValidPalindrome validPalindrome = new ValidPalindrome();
    @Test
    void test1() {
        Assertions.assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
