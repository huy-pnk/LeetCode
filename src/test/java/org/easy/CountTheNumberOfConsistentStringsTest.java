package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountTheNumberOfConsistentStringsTest {
    CountTheNumberOfConsistentStrings countTheNumberOfConsistentStrings = new CountTheNumberOfConsistentStrings();

    @Test
    void test1() {
        String allowed = "ab";
        String[] word = {"ad","bd","aaab","baa","badab"};
        int result = countTheNumberOfConsistentStrings.countConsistentStrings(allowed, word);
        assertEquals(result, 2);
    }

    @Test
    void test2() {
        String allowed = "abc";
        String[] word = {"a","b","c","ab","ac","bc","abc"};
        int result = countTheNumberOfConsistentStrings.countConsistentStrings(allowed, word);
        assertEquals(7, result);
    }
}
