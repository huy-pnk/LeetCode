package org;


import org.algorithm.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    private final BinarySearch binarySearch = new BinarySearch();
    @Test
    void test1() {
        Assertions.assertEquals(3, binarySearch.binarySearch(new int[] {1,2,3,4,5,6}, 4, 0, 5));
    }

    @Test
    void test2() {
        Assertions.assertEquals(5, binarySearch.binarySearch(new int[] {1,2,3,4,5,6}, 6, 0, 5));
    }
}
