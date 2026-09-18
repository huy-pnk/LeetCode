package org.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LexGreaterPermutationTest {
    private final LexGreaterPermutation lexGreaterPermutation = new LexGreaterPermutation();

    @Test
    public void test1() {
        String s = "abc";
        String target = "bba";

        assertEquals("bca", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

    @Test
    public void test2() {
        String s = "leet";
        String target = "code";

        assertEquals("eelt", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

    @Test
    public void test3() {
        String s = "baba", target = "bbaa";
        assertEquals("", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

    @Test
    public void test4() {
        String s = "a", target = "b";
        assertEquals("", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

    @Test
    public void test5() {
        String s = "aa", target = "bb";
        assertEquals("", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

    @Test
    public void test6() {
        String s = "ab", target = "ab";
        assertEquals("ba", lexGreaterPermutation.lexGreaterPermutation(s, target));
    }

}
